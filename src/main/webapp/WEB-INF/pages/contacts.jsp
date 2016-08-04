<%@page session="true"%>
<%@include file="header.jsp"%>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
<script>
	$(document).on("click", ".confirm", function(e) {
		e.preventDefault();
		var location = $(this).attr('href');
		bootbox.confirm("Delete this contact?", function(result) {
			if (result) {
				window.location.replace(location);
			}
		});
	});
</script>

<script>
	function goBack() {
		window.history.back();
	}
</script>

<c:if test="${not empty person}">
	<div class="msg">${person}</div>
</c:if>

<br>
<div class="panel panel-success">
	<div class="panel-heading">
		<h3 class="panel-title">Contacts</h3>
	</div>
	<br>
	<table class="table table-striped table-bordered">
		<tr>
			<th>ID</th>
			<th>FIO</th>
			<th>Number</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="person" items="${contacts}">
			<tr>
				<td><c:out value="${person[0]}" /></td>
				<td><c:out value="${person[1]}" /></td>
				<td><c:out value="${person[2]}" /></td>
				<td><a href="contacts/edit/id/${person[0]}" id="${person[0]}"><span
						class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
				<td><a class="confirm" href="contacts/delete/id/${person[0]}"
					id="${person[0]}"> <span class="glyphicon glyphicon-trash"
						aria-hidden="true"></span>
				</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
<div class="row">
	<div class="col-lg-7" style="margin-left: 10px;">
		<a type="submit" class="btn btn-success btn-sm" href="contacts/add">Add
			contact</a> <input type="button" onclick="goBack()"
			class="btn btn-cancell" value="Go back" /> <br> <br>
		<form method="get" action="contacts/search">
			<div class="small-3 columns">
				<input type="text" id="txt" name="searchString">
			</div>
			<br>
			<div class="small-5 columns end">
				<button id="button-id" type="submit" class="btn btn-success btn-sm">Search
					contacts</button>
			</div>
		</form>
	</div>
</div>
</body>
</html>