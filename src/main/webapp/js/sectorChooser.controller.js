(function () {
	'use strict';
	angular.module('sector-chooser')
		.controller('SectorChooserController', SectorChooserController);

	SectorChooserController.$inject = ['$http'];

	function SectorChooserController($http) {
		var vm = this;
		vm.init = init;
		vm.submitForm = submitForm;
		vm.chooseStyle = chooseStyle;
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
			vm.messageContainer = null;
			$http.post('/sectors', vm.newForm).then(function (result) {
				var apiResponse = result.data;
				if (apiResponse.ok){
					var savedForm = apiResponse.data;
					var index = _.indexOf(vm.formData.forms, _.find(vm.formData.forms, {id: savedForm.id}));
					vm.formData.forms.splice(index, 1, savedForm);
					vm.newForm = vm.formData.forms[0];
					vm.messageContainer = vm.newForm.container;
				} else {
					vm.messageContainer = apiResponse.data;
				}
			})
		}

		function chooseStyle(element) {
			if (element && element.level){
				if (element.level == 1){
					return {};
				} else if (element.level == 2){
					return {"margin-left" : "20px"}
				} else if (element.level == 3){
					return {"margin-left" : "40px"}
				} else if (element.level == 4){
					return {"margin-left" : "60px"}
				} else if (element.level == 5){
					return {"margin-left" : "80px"}
				}
			}

		}
	}
})();