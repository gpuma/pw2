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
  <ul>
    <li>Telefono: ${cond.telefono}</li>
    <li>Fecha de nacimiento: ${cond.fecNac}</li>
  </ul>
  <h2>Reviews</h2>
  <table>
    <tr>
      <th>Comentario</th>
      <th>Fecha</th>
      <th></th>
    </tr>
    <c:forEach items="${cond.reviews}" var="r">
      <tr>
      <td>${r.comentario}</td>
      <td>${r.fecha}</td>
      <td><a href="/conductor/${cond.usuario}/reviews/${r.id}/modificar">Editar</a></td>
      </tr>
    </c:forEach>
  </table>
  <h2>Nuevo comentario</h2>
  <div>
    <input type="text" id="review" name="review" />
    <input type="submit" value="Agregar review" />
  </div>
  <a href="/conductores">Regresar</a>
</form:form>
</body>
</html>
