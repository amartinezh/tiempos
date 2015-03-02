<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url var="actionUrl" value="/fechas/generar" />

<form:form id="fechaForm" commandName="fecha" method="post" action="${ actionUrl }" class="pure-form pure-form-aligned">

	<fieldset>
		<legend></legend>
		<br>
		<div class="pure-control-group">
			<label for="code">Año ha generar:</label>
			<form:input path="ano" placeholder="ano" maxlength="4" />
		</div>

	</fieldset>
</form:form>