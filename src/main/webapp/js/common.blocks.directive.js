(function () {
	'use strict';
	angular
		.module('sector-chooser')
		.directive('row12', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '' +
				'<div class="row">' +
					'<div class="large-12 medium-12 small-12 columns end" ng-transclude></div>' +
				'</div>'
			}
		});
	angular
		.module('sector-chooser')
		.directive('row4', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '' +
				'<div class="row">' +
				'<div class="large-4 medium-6 small-12 columns end" ng-transclude></div>' +
				'</div>'
			}
		});
	angular
		.module('sector-chooser')
		.directive('clear10', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-10"></div>'
			}
		});
	angular
		.module('sector-chooser')
		.directive('clear20', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-20"></div>'
			}
		});
	angular
		.module('sector-chooser')
		.directive('clear30', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-30"></div>'
			}
		});
	angular
		.module('sector-chooser')
		.directive('clear40', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-40"></div>'
			}
		});
})();