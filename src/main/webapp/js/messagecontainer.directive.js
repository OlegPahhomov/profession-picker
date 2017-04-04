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
				'<div ng-repeat="value in vm.messageContainer.errors" style="color:red"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.successes" style="color:green"><span ng-bind="value"></span></div>' +
				'<div ng-repeat="value in vm.messageContainer.notifications" style="color: blue"><span ng-bind="value"></span></div>'
			}
		})
})();