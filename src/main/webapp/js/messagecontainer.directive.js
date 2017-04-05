(function () {
	'use strict';
	angular
		.module('profession-picker')
		.directive('messageContainer', function () {
			return {
				restrict: 'E',
				replace: true,
				transclude: false,
				template: '' +
				'<div ng-if="vm.messageContainer">' +
				'<div class="row">' +
				'<div class="large-4 medium-6 small-12 columns">' +
				'<div ng-repeat="value in vm.messageContainer.errors" class="callout alert"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.successes" style="color:green"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.notifications" style="color: blue"><span ng-bind="value"></span></div>' +
				'</div> ' +
				'</div> '
			}
		})
})();