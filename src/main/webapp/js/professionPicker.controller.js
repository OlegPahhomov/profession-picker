(function () {
	'use strict';
	angular.module('profession-picker')
		.controller('ProfessionPickerController', ProfessionPickerController);

	ProfessionPickerController.$inject = [];

	function ProfessionPickerController() {
		var vm = this;
		console.log("init");
	}
})();