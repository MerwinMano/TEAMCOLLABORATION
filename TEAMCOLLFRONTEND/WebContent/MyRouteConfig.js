var myApp=angular.module("myApp",["ngRoute"]);

myApp.config(function($routeProvider)
		{
	console.log("I am in Route Provider");
	$routeProvider.when("/",{templateUrl:"template/index.jsp"})
	.when("#/Home",{templateUrl:"template/index.jsp"})
	.when("#/Register",{templateUrl:"template/Register.html"})
	.when("#/Login",{templateUrl:"template/Login.html"})

		});