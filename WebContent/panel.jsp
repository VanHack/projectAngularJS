<div class="container">	
	<div class="question">
		<h3 ng-if="quizPanel != null">Question number: {{quizPanel.id}}</h3>
		<h1 ng-if="quizPanel != null">{{quizPanel.description}}</h1>
		<h1 ng-if="quizPanel == null">Wait for the next question :)</h1>
	</div>
</div>
<div ng-show="loading" class="loading">Loading...</div>