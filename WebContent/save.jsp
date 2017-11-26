	<form ng-submit="send(quiz)" class="form-horizontal" style="margin: 70px">
	{{msg}}
		<div class="form-group">
			<label class="control-label col-sm-2" for="nome">Question:</label>
			<div class="col-sm-10">
				<input ng-model="quiz.description" type="text" class="form-control" />
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Option A:</label>
			<div class="col-sm-10">
				<input ng-model="quiz.optionA" type="text" class="form-control" />
      		</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Option B:</label>
			<div class="col-sm-10">
				<input ng-model="quiz.optionB" type="text" class="form-control" />
      		</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Option C:</label>
			<div class="col-sm-10">
				<input ng-model="quiz.optionC" type="text" class="form-control" />
      		</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="email">Correct answer:</label>
			<div class="col-sm-10">
				<input ng-model="quiz.correctOption" type="text" class="form-control" />
      		</div>
		</div>
		<div class="form-group">
			<div class="col-sm-2"></div>
			<div class="col-sm-10">
				<button class="btn btn-lg btn-success" type="submit">Save</button>
			</div>
		</div>
	</form>	
<div ng-show="loading" class="loading">Loading...</div>