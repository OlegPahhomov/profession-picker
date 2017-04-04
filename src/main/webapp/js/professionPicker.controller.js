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
			$http.get('/sectors').then(function (result) {
				var apiResponse = result.data
				if (apiResponse.ok) {
					vm.formData = apiResponse.data;
					if (vm.formData.forms){
						vm.newForm = vm.formData.forms[0];
					} else {
						vm.newForm = {}
					}
				}
			})
		}

		function submitForm() {
			$http.post('/sectors', vm.newForm).then(function (result) {
				var apiResponse = result.data;
				if (apiResponse.ok){
					var savedForm = apiResponse.data;
					var index = _.indexOf(vm.formData.forms, _.find(vm.formData.forms, {id: savedForm.id}));
					vm.formData.forms.splice(index, 1, savedForm);
				} else {
					vm.messageContainer = apiResponse.data;
				}
			})
		}
	}
})();