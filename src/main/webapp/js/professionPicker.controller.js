(function () {
	'use strict';
	angular.module('profession-picker')
		.controller('ProfessionPickerController', ProfessionPickerController);

	ProfessionPickerController.$inject = ['$http'];

	function ProfessionPickerController($http) {
		var vm = this;
		vm.init = init;
		vm.submitForm = submitForm;
		vm.init();

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

		function submitForm() {
			console.log(12321);
			$http.post('/sectors', vm.formData).then(function (result) {
				var apiResponse = result.data;
				if (apiResponse.ok){
					console.log("so hapy;");
				} else {
					console.log("so saaad;");
					console.log(apiResponse.data);
					vm.messageContainer = apiResponse.data;
				}
			})
		}
	}
})();