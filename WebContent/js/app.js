angular.module('app', ['controller', 'ngRoute'])

.config(function($routeProvider) {
    $routeProvider

	    // route to panel page
	    .when('/panel', {
	    	templateUrl : 'panel.jsp',
	    	controller  : 'QuizControl'
	    })
    
        // route to main page
        .when('/list', {
            templateUrl : 'list.jsp',
            controller  : 'QuizControl'
        })

        // route to save page
        .when('/save', {
            templateUrl : 'save.jsp',
            controller  : 'QuizControl'
        });
});

