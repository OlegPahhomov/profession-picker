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
				'<div ng-if="vm.messageContainer">'+
				'<div ng-repeat="value in vm.messageContainer.errors"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.successes"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.notifications"><span ng-bind="value"></span></div>'
			}
		})
})();