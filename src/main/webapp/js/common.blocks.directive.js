(function () {
	'use strict';
	angular
		.module('profession-picker')
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
		.module('profession-picker')
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
		.module('profession-picker')
		.directive('clear10', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-10"></div>'
			}
		});
	angular
		.module('profession-picker')
		.directive('clear20', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-20"></div>'
			}
		});
	angular
		.module('profession-picker')
		.directive('clear30', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-30"></div>'
			}
		});
	angular
		.module('profession-picker')
		.directive('clear40', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: true,
				template: '<div class="clear-40"></div>'
			}
		});
})();