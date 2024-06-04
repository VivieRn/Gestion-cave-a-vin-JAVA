<%@include file="template/tags.jsp" %>

<!DOCTYPE>
<html>
<%@include file="template/head.jsp" %>
<body>

	<%@include file="template/nav.jsp" %>
	<div class="container">
	<h1 class="bleu">Liste des bouteilles<span class="badge btn-primary gros pull-right">${ fn:length(listeB)}</span></h1>
	<br>
	<form action="lister" method="GET" class="form-horizontal">
		<div class="form-group" id="blocFiltre">			
			<label id="labelFiltre" for="filtre" class="col-xs-2 control-label">Filtre :</label>
			<div class="col-xs-10">
				<div class="input-group">
			      <input name="filtre"  placeholder="Filtre sur le nom du vin ..."  class="form-control" value="${filtre }" /> 
			      <span class="input-group-btn">
			        <button class="btn btn-primary" type="submit">Envoyer</button>
			        <a class="btn btn-info" href="effacerFiltre">Effacer Filtre</a>
			      </span>
			    </div><!-- /input-group -->
			    
			</div>
		</div>
	</form>
	<br>
	<table class="table table-hover table-striped">
		<tr>
			<th><a href="trier?par=dA"><span class="glyphicon glyphicon-menu-down"></span></a> Nom <a
				href="trier?par=dD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=mA"><span class="glyphicon glyphicon-menu-down"></span></a> Millesime <a
				href="trier?par=mD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=cA"><span class="glyphicon glyphicon-menu-down"></span></a> Petillant <a
				href="trier?par=cD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=nA"><span class="glyphicon glyphicon-menu-down"></span></a> Quantite <a
				href="trier?par=nD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=coA"><span class="glyphicon glyphicon-menu-down"></span></a> Couleur <a
				href="trier?par=coD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th><a href="trier?par=rA"><span class="glyphicon glyphicon-menu-down"></span></a> Region <a
				href="trier?par=rD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
			<th></th>
			<th></th>
		</tr>
	
		<c:forEach items="${listeB}" var="b" varStatus="bStatus">
			<tr>
				<td><a href="afficher?index=${b.id}">${b.nom}</a></td>
				<td>${b.millesime}</td>
<%-- 				<td><c:if test="${b.petillant}">Oui</c:if><c:if test="${!b.petillant}">Non</c:if></td> --%>
				<td>${b.petillant?"Oui":"Non"}</td>
				<td>${b.quantite}</td>
				<td>${b.couleur.nom}</td>
				<td>${b.region.nom}</td>
				<td class="centre">
					<span class="modif glyphicon glyphicon-edit vert"  id="m${b.id}"></span>
				</td>
				<td class="centre">
					<span class="glyphicon glyphicon-remove rouge supp"  id="s${b.id}"></span>
				</td>
			</tr>
		</c:forEach>
		

	</table>


	</div>
<%@include file="template/footer.jsp" %>

</body>
</html>