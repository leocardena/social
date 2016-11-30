(function() {
    'use strict';

    angular
        .module('social.search')
        .controller('SearchController', SearchController);

    SearchController.$inject = ['TraktSearchService', 'searchPrepService'];

    function SearchController (TraktSearchService, searchPrepService) {
        var vm = this;
        vm.results = searchPrepService;
        console.log(searchPrepService);
    }
    
})();
