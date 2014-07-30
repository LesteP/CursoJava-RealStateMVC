<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src ='<c:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
<title>Lista de Propietarios</title>
</head>

<body>
Buscar por nombre:<input type="text" id="txtBuscar" placeholder="Escribe su nombre">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 
<br />

<a href="altaPropietario.html">Add new Owner</a>
<br />
	   
<table id="tblDatos">
<c:forEach items="${propietarios}" var="propietario">
 <tr>
   <td>${propietario.idPropietario }</td>
   <td>${propietario.nombre }</td>
   <td>${propietario.dni }</td>
   
   <td><a href="detallePropietario.html?id=${propietario.idPropietario}"> Ver detalle</a></td>
   <td><a href="#" id="lnkDetalle" onclick="evento(${propietario.idPropietario})">Ver Detalle en Ajax</a></td>
   <td><a href="modificarPropietario.html/${propietario.idPropietario}"> Modificar</a></td>
   <td><a href="#" id="lnkBorrar" onclick="borrar(${propietario.idPropietario})">Borrar</a></td>
 
</tr>
 </c:forEach>
</table>
<div id="divDetalle"></div>
<script type="text/javascript">
function borrar(id){

	var datos={idPropietario:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"propietario",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Propietario erradicado muy satisfactoriamente MUAHAHA");
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
	var url="propietario/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});
            for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].idPropietario+"</td>";
			h+="<td>"+res[i].nombre+"</td>";
			h+="<td>"+res[i].dni+"</td>";
			h+="<td><a href='detallePropietario.html?id="+res[i].idPropietario+"'> Ver Detalle</a> ";
			h+="<a href='#' onclick='evento("+res[i].idPropietario+")'>Detalle en ajax</a>";
			h+="<a href='modificarPropietario.html/"+res[i].idPropietario+"'> Modificar</a> ";
			h+="<a href='#' onclick='borrar("+res[i].idPropietario+")'>Borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}
    });

}
function evento(id){
  	var url="propietario/"+id;
  	$.get(url,function(res){
var resultado="<ul>";
   resultado+="<li>"+ res.idPropietario+"<li>";
   resultado+="<li>"+ res.nombre+"<li>";
   resultado+="<li>"+ res.dni+"<li>";
 $("#divDetalle").html(resultado);
  	});
	
}
</script>
</body>
</html>
