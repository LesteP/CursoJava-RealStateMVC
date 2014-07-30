<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
	prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar los datos del Inquilino</title>
</head>
<body>
Modifica los datos del Inquilino 
	
	<form:form method="post" commandName="inquilino">
		
		<form:hidden path="idInquilino"/>
		DNI:<form:input path="dni"/><br />
		Nombre:<form:input path="nombre"/><br />
		Edad:<form:input path="edad"/><br />
		Trabaja:<form:input path="trabaja"/><br />
		<input type="submit" value="Guardar" />
    
    </form:form>
    
</body>
</html>