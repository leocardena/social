(function () {
	
	'use strict';
	
	 angular
       .module('social.blocks')
       .config(translateConfig);
	 
	 translateConfig.$inject = ['$translateProvider'];
	 
	 /*@ngInject*/
	 
	 function translateConfig($translateProvider) {
		 
		  $translateProvider.translations('pt', {
			    'movie': 'Filme',
			    'show': 'Série',
			    'person' : 'Pessoa',
			    'action' : 'Ação',
			    'adventure' : 'Aventura',
			    'animation' : 'Animação',
			    'comedy' : 'Comédia',
			    'disaster' : 'Desastre',
			    'documentary' : 'Documentário',
			    'family' : 'Família',
			    'fan film' : 'Filme de Fã',
			    'fantasy' : 'Fantasia',
			    'history' : 'História',
			    'holiday' : 'Feriado',
			    'music' : 'Música',
			    'mystery' : 'Mistério',
			    'none' : 'Nenhum',
			    'road' : 'Estrada',
			    'science fiction' : 'Ficção Científica',
			    'science-fiction' : 'Ficção Científica',
			    'short' : 'Curta Metragem',
			    'sporting event' : 'Evento Esportivo',
			    'sports' : 'Esporte',
			    'tv movie' : 'Novela',
			    'war' : 'guerra',
			    'drama' : 'Drama',
			    'horror' : 'Horror'
		  });
		  
		  $translateProvider.preferredLanguage('pt');
		  $translateProvider.useSanitizeValueStrategy('escape');
		 
	 }

})();