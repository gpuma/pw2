<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--necesario para poder usar funciones de JSTL-->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Editando review ${review.id}</title>
</head>
<body>
<form:form commandName="review" action="/conductor/${nomusu}/reviews/${review.id}/guardar" method="POST">
  <form:input path="comentario" />
  <input type="submit" value="Modificar review" />
  <a href="/conductores">Regresar</a>
</form:form>
</body>
</html>
