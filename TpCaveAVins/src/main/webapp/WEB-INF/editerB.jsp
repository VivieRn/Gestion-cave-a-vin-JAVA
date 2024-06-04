<%@include file="template/tags.jsp"%>
<!DOCTYPE>
<html>
<%@include file="template/head.jsp"%>
<body>

	<%@include file="template/nav.jsp"%>

	<div class="container">
		<h1 class="bleu">Edition de la fiche du vin</h1>
		<br>
		<div>
			<form action="editer" method="POST" class="form-horizontal">
				<div class="form-group">
					<label for="id" class="col-xs-2 control-label">Id :</label>
					<div class="col-xs-10">
						<input name="id" readonly="readonly" class="form-control"
							value="${bout.id}" />
					</div>
				</div>
				<%@include file="template/formulaire.jsp"%>

			</form>
		</div>
	</div>

	<%@include file="template/footer.jsp"%>
</body>
</html>