<%@include file="header.jsp"%>

<script>
	function goBack() {
		window.history.back();
	}
</script>

<br>
<br>
<br>
<div class="container">
	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title">Add new contact:</h3>
		</div>
		<c:url var="saveUrl" value="/contacts/add" />
		<form:form modelAttribute="personForm" method="POST"
			action="${saveUrl}">
			<table class="table table-striped table-bordered">
				<tr>
					<spring:bind path="fio">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">FIO:</label>
							<div class="col-sm-10">
								<form:input path="fio" type="text" class="form-control" id="fio"
									placeholder="FIO" required="true" maxlength="45" />
								<form:errors path="fio" class="control-label" />
							</div>
						</div>
						<br>
						<br>
						<br>
					</spring:bind>
				</tr>
				<tr>
					<spring:bind path="fio">
						<div class="form-group ${status.error ? 'has-error' : ''}">
							<label class="col-sm-2 control-label">Number:</label>
							<div class="col-sm-10">
								<form:input path="number" type="text" class="form-control"
									id="number" placeholder="Number" required="true" maxlength="45" />
								<form:errors path="number" class="control-label" />
							</div>
						</div>
						<br>
						<br>
						<br>
					</spring:bind>
				</tr>
			</table>
			<p style="text-align: center">
				<input type="submit" class="btn btn-success" value="Add" /> <input
					type="button" onclick="goBack()" class="btn btn-cancell"
					value="Go back" />
			</p>
		</form:form>
	</div>
</div>