<%@include file="template/tags.jsp"%>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp"%>
<body>

	<%@include file="template/nav.jsp"%>
	<div class="container">
		<h1 class="bleu">Ajout d'un vin</h1>
		<br>
		<br>
		<div>
			<form action="ajouter" method="POST" class="form-horizontal">

				<%@include file="template/formulaire.jsp"%>

			</form>
		</div>

	</div>
	<%@include file="template/footer.jsp"%>

</body>
</html>