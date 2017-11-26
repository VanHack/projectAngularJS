<div class="col-md-12">
	<table class="table table-striped">
		<tr>
			<th>Number</th>
			<th>Question</th>
			<th>Option A</th>
			<th>Option B</th>
			<th>Option C</th>
			<th>Correct Option</th>
			<th>Show</th>
		</tr>
		<tr ng-repeat="quiz in quizzes | orderBy : 'description' : false"> <!-- false = DESC -->
			<td>{{quiz.id }}</td>
			<td ng-click="edit(quiz)">{{quiz.description }}</td>
			<td>{{quiz.optionA }}</td>
			<td>{{quiz.optionB }}</td>
			<td>{{quiz.optionC }}</td>
			<td>{{quiz.correctOption }}</td>
			<td style="cursor: pointer;" ng-click="show(quiz)"> <img ng-src="{{quiz.available? 'img/true.png': 'img/false.png'}}" /></td>
		</tr>
	</table>
	{{msg}} 
	<div class="col-md-2" ng-repeat="q in  quizzes" ng-click="show(q)" style="cursor: pointer;height:140px">
		<div ng-class="q.available? 'panel panel-teal' : 'panel panel-error'">
			<div class="panel-heading">
				{{q.description }}
			</div>
		</div>
	</div>
</div>
<br>
<div ng-show="loading" class="loading">Loading...</div>
