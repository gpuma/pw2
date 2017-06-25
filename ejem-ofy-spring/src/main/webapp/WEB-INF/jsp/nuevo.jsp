<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo conductor</title>
</head>
<body>
<!--enctype es para poder mandar los parámetros junto con la imagen-->
<form:form commandName="cond" action="/conductores/registrar" method="POST" enctype="multipart/form-data">
  <h1>Nuevo conductor</h1>
  Usuario <form:input id="usuario" path="usuario"/>
  Telefono <form:input id="telefono" path="telefono"/>
  Fecha Nacimiento <form:input id="fecNac" path="fecNac"/>
  Foto perfil <input type="file" name="archivo" id="archivo"/>
  <!--Fecha Nacimiento <form:input type="date" pattern="dd/MM/yyyy" id="fecNac" path="fecNac"/>-->
  <input type="submit" name="Registrar" />
</form:form>
</body>
</html>
