sap.ui.define([
	"sap/ui/core/mvc/Controller",
	"sap/m/MessageBox",
	"sap/m/MessageToast",	
	"Doraemon/util/service"
], function(Controller, MessageBox, MessageToast, Service){
	return Controller.extend("Doraemon.controller.Main",{
		onInit: function(){
			var oModel = new sap.ui.model.json.JSONModel();
			oModel.setData({
				"vendor": {
					
					  		"companyName": "Enter company name ",
					        "contactPerson": "Enter manager name",
					        "firstName": "Enter first name",
					        "lastName": "Enter sast name",
					        "status": "Enter status",
					        "website": "Enter website",
					        "email": "Enter email ID",
					        "regdate": new Date()

					    },
					 "vendorTab": []
			});
			this.getView().setModel(oModel); //this line will set the model with the application
			this.fetchAndLoadData();	
		},
		
		fetchAndLoadData: function(){

            var oModel = this.getView().getModel();

            Service.callService("/vendor","GET").then(function(data){

                oModel.setProperty("/vendorTab", data);

                MessageToast.show(data.length.toString() + " Records were loaded");

            }).catch(function(oError){

                MessageBox.error("Data fetch failed");

            });

            

        },
        onDelete: function(){
			
		},
		onSave: function(){
			
			//Step 1: Access the data from the model - whatever changes user did
			//        will reflect inside model from UI
				
		    var oModel = this.getView().getModel();
		    var payload = oModel.getProperty("/vendor");
		    var that=this;
			//Step 2: Use the service class object to POST Data
			Service.callService("/vendor", "POST", payload)
			//Step 3: We will display message to user
			.then(function(){
				MessageBox.confirm("Your vendor is now saved");
				that.fetchAndLoadData().bind(that);
			})
			.catch(function(){
				MessageBox.confirm("The Vendor Creation Failed");
			})
			
			
		}
	});
});
