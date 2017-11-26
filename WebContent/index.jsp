<!DOCTYPE html>
<html ng-app="app">
<head>
<meta charset="ISO-8859-1">
<title>Administrator panel</title>

<script type="text/javascript" src="js/angular.min.js"></script>
<script type="text/javascript" src="js/angular-route.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/app.js"></script>
<script src="js/controller.js"></script>

</head>
<body>

	<div class="col-md-12">
		<ul class="nav navbar-nav navbar-left">    
		    <li><a href="#panel"> Panel</a></li>    
		    <li><a href="#list"> List</a></li>    
		    <li><a href="#save"> Create</a></li>    
	    </ul>
	</div>
	<br />
    <div id="main">
		<div ng-view ></div>
    </div>
</body>
</html>