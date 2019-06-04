<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.route.min.js"></script>
<script src="MyRouteConfig.js"></script>
</head>
<body ng-app="myApp">
<table width="70%" align="center" cellspacing="2">
<tr bgcolor="cyan">
<td colspan="2">TeamCollaboration</td>
</tr>
<tr bgcolor="pink">
<td>
<br/><br/><br/><br/>
<a href="#/Home">Home</a><br/>
<a href="#/Login">Login</a><br/>
<a href="#/Register">Register</a><br/>
<br/><br/><br/><br/>
</td>
<td><div ng-view></div></td>
</tr>

</table>

</body>

</head>
</html>