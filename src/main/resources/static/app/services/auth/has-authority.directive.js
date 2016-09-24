(function() {
    'use strict';

    angular
        .module('social.services')
        .directive('hasAuthority', hasAuthority);

    hasAuthority.$inject = ['PrincipalService'];

    function hasAuthority(PrincipalService) {
        var directive = {
            restrict: 'A',
            link: linkFunc
        };

        return directive;

        function linkFunc(scope, element, attrs) {
            var authority = attrs.hasAuthority.replace(/\s+/g, '');

            var setVisible = function () {
                    element.removeClass('hidden');
                },
                setHidden = function () {
                    element.addClass('hidden');
                },
                defineVisibility = function (reset) {

                    if (reset) {
                        setVisible();
                    }

                    PrincipalService.hasAuthority(authority)
                        .then(function (result) {
                            if (result) {
                                setVisible();
                            } else {
                                setHidden();
                            }
                        });
                };

            if (authority.length > 0) {
                defineVisibility(true);

                scope.$watch(function() {
                    return PrincipalService.isAuthenticated();
                }, function() {
                    defineVisibility(true);
                });
            }
        }
    }
})();
