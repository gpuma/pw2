<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--necesario para poder usar funciones de JSTL-->
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Conductores</title>
</head>
<body>
<form:form commandName="conductores">
  <h1>Conductores</h1>
  <!--si mensaje no existe simplemente no se muestra-->
  <h4>${mensaje}</h4>
  <c:if test="${fn:length(conductores)==0}">
    <h2>No hay conductores registrados.</h2>
  </c:if>
  <c:if test="${fn:length(conductores)!=0}">
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
            <td><a href="eliminar/${c.usuario}">Eliminar</a></td>
        </tr>
    </c:forEach>
    </table>
  </c:if>
  <a href="nuevo">Nuevo conductor...</a>
</form:form>
</body>
</html>
