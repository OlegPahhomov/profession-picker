(function () {
	'use strict';
	angular
		.module('sector-chooser')
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
				'<div ng-repeat="value in vm.messageContainer.successes" class="callout success"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.notifications" class="callout primary"><span ng-bind="value"></span></div>' +
				'</div> ' +
				'</div> '
			}
		})
})();