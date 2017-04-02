(function () {
	'use strict';
	angular
		.module('profession-picker', [
			'ngRoute'
		])
		.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {
			var urlBase = "/resources/";
			$locationProvider.hashPrefix('');
			$routeProvider
				.when("/", {
					templateUrl: urlBase + "frontpage.html",
					controller: 'ProfessionPickerController as vm'
				})
				.when("/original", {
					templateUrl: urlBase + "original_index.html",
				})
				.otherwise({redirectTo:'/'})
		}]);
})();