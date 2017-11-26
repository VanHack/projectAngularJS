angular.module('controller', [])

.controller('QuizControl', ['$scope', '$http', '$location', function($scope, $http, $location){ 
	
	var url = "https://cors-anywhere.herokuapp.com/http://hockeygamepanel.us-east-1.elasticbeanstalk.com/api"
//	var url = "http://localhost:8081/projetoAngularJS/api"
	
	$scope.loading = true;
	init = function(){ // Like a webservice back-end
		$http.get(url + '/quiz/list').then(function(response){
			$scope.quizzes = response.data;
		}).finally(function () {
	      $scope.loading = false;
	    });
		$http.get(url + '/quiz/showPanelQuiz').then(function(response){
			$scope.quizPanel = response.data;
		}).finally(function () {
	      $scope.loading = false;
	    });
	}
	init(); 
	
	$scope.send = function(quiz){
		$scope.loading = true;
		console.log(angular.toJson(quiz));
		var parameter = JSON.stringify({description:quiz.description, optionA:quiz.optionA, 
			optionB:quiz.optionB, optionC:quiz.optionC, correctOption:quiz.correctOption })
		$http.post(url + "/quiz/merge", parameter, {headers: {'Content-Type': 'application/json'} }).then(function(response){
//		$http.get(url + '/quiz/merge/'
//					+ quiz.description + "/" + quiz.optionA+ "/" + quiz.optionB+ "/" + quiz.optionC
//					+ "/" + quiz.correctOption+"/").then(function(response){
			console.log(response);
			$scope.msg = "Success!";
		}).finally(function () {
	      $scope.loading = false;
	      $scope.quiz = null;
	    });
		
	}
	
	$scope.show = function(quiz){
		$scope.loading = true;
		console.log(angular.toJson(quiz)); 
		$http.get(url + '/quiz/show/'
				+ quiz.id).then(function(response){
					console.log(response);
					init(); // Refresh the list
		})
	}
	
	$scope.edit = function(quiz){// No more time... I'm in an hurry!
		console.log(quiz); 
	}
	
}]);