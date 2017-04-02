(function () {
	'use strict';
	angular.module('profession-picker')
		.controller('ProfessionPickerController', ProfessionPickerController);

	ProfessionPickerController.$inject = ['$http'];

	function ProfessionPickerController($http) {
		var vm = this;
		vm.init = init;
		vm.init();


		console.log("init");
		function init() {
			console.log("init");
			$http.get('/sectors').then(function (result) {
				var apiResponse = result.data
				if (apiResponse.ok) {
					vm.formData = apiResponse.data;
					console.log(vm.formData);
				}
			})
		}
	}
})();