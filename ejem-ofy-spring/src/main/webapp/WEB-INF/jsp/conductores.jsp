<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Conductores</title>
</head>
<body>
<form:form commandName="conductores">
  <h1>Conductores</h1>
  <table>
  <tr>
      <th>Usuario</th>
      <th>Telefono</th>
      <th>Fecha Nac.</th>
  </tr>
  <c:forEach items="${conductores}" var="c">
      <tr>
          <td>${c.usuario}</td>
          <td>${c.telefono}</td>
          <td>${c.fecNac}</td>
      </tr>
  </c:forEach>
  </table>
</form:form>
</body>
</html>
