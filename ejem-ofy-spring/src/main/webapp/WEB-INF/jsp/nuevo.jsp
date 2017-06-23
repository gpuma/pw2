<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo conductor</title>
</head>
<body>
<form:form commandName="cond" action="/registrar" method="POST">
  <h1>Nuevo conductor</h1>
  Usuario <form:input id="usuario" path="usuario"/>
  Telefono <form:input id="telefono" path="telefono"/>
  Fecha Nacimiento <form:input id="fecNac" path="fecNac"/>
  <!--Fecha Nacimiento <form:input type="date" pattern="dd/MM/yyyy" id="fecNac" path="fecNac"/>-->
  <input type="submit" name="Registrar" />
</form:form>
</body>
</html>
