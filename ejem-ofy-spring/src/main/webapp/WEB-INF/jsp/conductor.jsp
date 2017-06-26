<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--necesario para poder usar funciones de JSTL-->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Conductor ${cond.usuario}</title>
</head>
<body>
<form:form commandName="cond" action="/conductores/${cond.usuario}/reviews/nuevo" method="POST">
  <h1>${cond.usuario}</h1>
  <h4>${cond.telefono}</h4>
  <h4>${cond.fecNac}</h4>
  <ul>
    <c:forEach items="${cond.reviews}" var="r">
      <li>${r.id}</li>
      <li>${r.comentario}</li>
      <li>${r.fecha}</li>
    </c:forEach>
  </ul>
  <h2>Nuevo comentario</h2>
  <div>
    <input type="text" id="review" name="review" />
    <input type="submit" value="Agregar review" />
  </div>
  <a href="/conductores">Regresar</a>
</form:form>
</body>
</html>
