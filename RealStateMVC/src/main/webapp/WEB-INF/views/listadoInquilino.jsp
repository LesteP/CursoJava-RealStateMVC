<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src ='<c:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
<title>Lista de Inquilinos</title>
</head>

<body>

<font color="Silver" face="Comic Sans MS">
		
	<h2 align="center">Pss Cotilla!! Tenemos sindrome de portera ehh JAJAJ</h2>

<font color="Navy" face="Courier">
Buscar:<input type="text" id="txtBuscar" placeholder="Escribe su nombre">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 


<a href="altaInquilino.html">Add new Tenant</a>

	   
<table id="tblDatos">
<c:forEach items="${inquilinos}" var="inquilino">
 <tr>
   <td>${inquilino.idInquilino}</td>
   <td> <font color="red" face="Time New Roman"> ${inquilino.dni}</td>
   <td> <font color="teal" face="Arial"> ${inquilino.nombre}</td>
   <td>${inquilino.edad}</td>
   <td>${inquilino.trabaja}</td>
   
   <td><a href="detalleInquilino.html?id=${inquilino.idInquilino}"> Ver detalle</a></td>
   <td><a href="#" id="lnkDetalle" onclick="evento(${inquilino.idInquilino})">Ver Detalle en Ajax</a></td>
   <td><a href="modificarInquilino.html/${inquilino.idInquilino}"> Modificar </a></td>
   <td><a href="#" id="lnkBorrar" onclick="borrar(${inquilino.idInquilino})">Borrar</a></td>
 
</tr>
 </c:forEach>
</table>
<div id="divDetalle"></div>
<script type="text/javascript">
function borrar(id){

	var datos={idInquilino:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"inquilino",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Inquilino felizmente desahuciado");
					$("#txtBuscar").text("");
					buscar();

					},
				error: function(res){
					alert(JSON.stringify(res));
					}


				}
			);
}

function buscar(){
	var tx=$("#txtBuscar").val();
	if(tx=="")
		tx="NoBuscoNada";
	var url="inquilino/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});
            for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].idInquilino+"</td>";
			h+="<td>"+res[i].dni+"</td>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].edad+"</td>";
			h+="<td>"+res[i].trabaja+"</td>";
			h+="<td><a href='detalleInquilino.html?id="+res[i].idInquilino+"'> Ver Detalle</a> ";
			h+="<a href='#' onclick='evento("+res[i].idInquilino+")'>Detalle en ajax</a>";
			h+="<a href='modificarInquilino.html/"+res[i].idInquilino+"'> Modificar</a> ";
			h+="<a href='#' onclick='borrar("+res[i].idInquilino+")'>Borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}
    });

}
function evento(id){
  	var url="inquilino/"+id;
  	$.get(url,function(res){
var resultado="<ul>";
   resultado+="<li>"+ res.idInquilino+"<li>";
   resultado+="<li>"+ res.dni+"<li>";
   resultado+="<li>"+ res.nombre+"<li>";
   resultado+="<li>"+ res.edad+"<li>";
   resultado+="<li>"+ res.trabaja+"<li>"; 
   $("#divDetalle").html(resultado);
  	});
	
}
</script>
</body>
</html>
