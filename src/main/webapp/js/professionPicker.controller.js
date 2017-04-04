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
					console.log("so hapy;");
					// var index = _.indexOf(vm.staaz.dokumendid, _.find(vm.staaz.dokumendid, {tempId: vm.dokument.tempId}));
					// vm.staaz.dokumendid.splice(index, 1, vm.dokument);
					// vm.showDocumentModalEdit = false;
					// vm.dokument = undefined;

				} else {
					console.log("so saaad;");
					console.log(apiResponse.data);
					vm.messageContainer = apiResponse.data;
				}
			})
		}
	}
})();