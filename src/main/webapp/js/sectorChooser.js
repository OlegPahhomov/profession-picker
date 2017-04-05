(function () {
	'use strict';
	angular
		.module('sector-chooser', [
			'ngRoute'
		])
		.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
			var urlBase = "/resources/";
			$locationProvider.hashPrefix('');
			$routeProvider
				.when("/", {
					templateUrl: urlBase + "frontpage.html",
					controller: 'SectorChooserController as vm'
				})
				.when("/original", {
					templateUrl: urlBase + "original_index.html",
				})
				.otherwise({redirectTo:'/'})
		}]);
})();