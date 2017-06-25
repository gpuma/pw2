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
<form:form commandName="cond">
  <h1>${cond.usuario}</h1>
  <h4>${cond.telefono}</h4>
  <h4>${cond.fecNac}</h4>
  <ul>
    <c:forEach items="${cond.reviews}" var="r">
      <li>${r.comentario}</li>
      <li>${r.fecha}</li>
    </c:forEach>
  </ul>
</form:form>
</body>
</html>
