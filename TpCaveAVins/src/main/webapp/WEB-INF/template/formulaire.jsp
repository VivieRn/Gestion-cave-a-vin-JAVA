<div class="form-group">
	<label for="nom" class="col-xs-2 control-label">Nom :</label>
	<div class="col-xs-10">
		<input required name="nom" placeholder="Nom du vin ..." class="form-control"
			value="${bout.nom}" ${empty enLecture?'':'readonly'} />
	</div>
</div>
<div class="form-group">
	<label for="millesime" class="col-xs-2 control-label">Millesime	:</label>
	<div class="col-xs-10">
		<input required name="millesime" placeholder="Millesime du vin ..."
			value="${bout.millesime}"  class="form-control" ${empty enLecture?'':'readonly'} />
	</div>
</div>
<div class="form-group">
	<label for="petillant" class="col-xs-2 control-label">Pétillant
		:</label>
	<div class="col-xs-10">
		<select name="petillant" class="form-control"
			${empty enLecture?'':'readonly disabled'}>
			<option value="true" <c:if test="${bout.petillant}">selected</c:if>>Oui</option>
			<option value="false" <c:if test="${!bout.petillant}">selected</c:if>>Non</option>
		</select>
	</div>
</div>

<div class="form-group">
	<label for="quantite" class="col-xs-2 control-label">Quantité :</label>
	<div class="col-xs-10">
		<input required name="quantite" placeholder="Quantité de bouteilles ..."
			class="form-control" value="${bout.quantite}"
			${empty enLecture?'':'readonly'} />
	</div>
</div>
<div class="form-group">
	<label for="couleurId" class="col-xs-2 control-label">Couleur :</label>
	<div class="col-xs-10">
		<c:choose>
			<c:when test="${empty enLecture}">
				<select name="couleurId" class="form-control">
					<c:forEach items="${listeCoul}" var="coul">
						<option value="${coul.id }"
							<c:if test="${coul.id == bout.couleur.id}">selected</c:if>>${coul.nom }</option>
					</c:forEach>
				</select>
			</c:when>
			<c:otherwise>
				<input id="couleur" value="${bout.couleur.nom}" readonly="readonly"
					class="form-control" />
			</c:otherwise>
		</c:choose>
	</div>
</div>

<div class="form-group">
	<label for="regionId" class="col-xs-2 control-label">Région :</label>
	<div class="col-xs-10">
		<c:choose>
			<c:when test="${empty enLecture}">
				<select name="regionId" class="form-control">
					<c:forEach items="${listeRegion}" var="reg">
						<option value="${reg.id }"
							<c:if test="${reg.id == bout.region.id}">selected</c:if>>${reg.nom }</option>
					</c:forEach>
				</select>
			</c:when>
			<c:otherwise>
				<input id="couleur" value="${bout.region.nom}" readonly="readonly"
					class="form-control" />
			</c:otherwise>
		</c:choose>
	</div>
</div>
<c:if test="${empty enLecture}">
	<div class="form-group">
		<div class="col-xs-offset-2 col-xs-10">
			<button type="submit" class="btn btn-primary">${bout.id > 0?'Modifier':'Envoyer'}</button>
		</div>
	</div>
</c:if>
