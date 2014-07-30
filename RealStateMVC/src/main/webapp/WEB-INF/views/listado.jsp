<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src ='<c:url value="/resources/js/jquery-1.11.1.min.js"/>'></script>
<title>Lista de Inmuebles</title>
</head>
<body>
<font color="Silver" face="Comic Sans MS,arial">
	
	<h1 align="center"><i>No se corte en utilizar nuestros servicios</i></h1>
	<h2 align="center">y si quiere cotillear por aqui, hagalo es gratis</h2>
	
<font color="Navy" face="Comic Sans MS,arial">
Direccion:<input type="text" id="txtBuscar" placeholder="Escribe la direccion">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()"> 

Precio:<input type="text" id="txtBuscar" placeholder="Escribe el precio">
	   <input type="button" id="btnBuscar" value="buscar" onclick="buscar()">
	   

<a href="altaInmueble.html">Add a new Property</a><br />

 
 <font color="blue" face="Comic Sans MS,arial">
   
   <!-- esto es la linea nueva, si falla a eliminar -->
   
<table id="tblDatos">
 <c:forEach items="${inmuebles}" var="inmueble">
  <tr>
   <td>${inmueble.idInmueble }</td>
   <td> <font color="teal" face="times new roman"> ${inmueble.direccion }</td>
   <td> <font color="red" face="Arial"> ${inmueble.precio }</td>
       
   <td><a href="detalle.html?id=${inmueble.idInmueble}"> Ver detalle</a></td>
   <td><a href="#" id="lnkDetalle" onclick="evento(${inmueble.idInmueble})">Ver Detalle en Ajax</a></td>
   <td><a href="modificarInmueble.html/${inmueble.idInmueble}"> Modificar</a></td>
   <td><a href="#" id="lnkBorrar" onclick="borrar(${inmueble.idInmueble})">Borrar</a></td>
  </tr>
 </c:forEach>
</table>   	


<div id="divDetalle"></div>
<script type="text/javascript">

function borrar(id){

	var datos={idInmueble:id};

	var datosPasar=JSON.stringify(datos);

	$.ajax(
			"inmueble",{
				data:datosPasar,
				method: "DELETE",
				contentType: "application/json",
				success: function(res){
					alert("Inmueble eliminado correctamente");
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
	var url="inmueble/buscar/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});
            for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].idInmueble+"</td>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalle.html?id="+res[i].idInmueble+"'> Ver Detalle</a> ";
			h+="<a href='#' onclick='evento("+res[i].idInmueble+")'>Detalle en ajax</a>";
			h+="<a href='modificarInmueble.html/"+res[i].idInmueble+"'> Modificar</a> ";
			h+="<a href='#' onclick='borrar("+res[i].idInmueble+")'>Borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}
    });

}
function buscarPrecio(){
	var tx=$("#txtBuscarPrecio").val();
	if(tx=="")
		tx="NoBuscoNada";
	var url="inmueble/buscarPrecio/"+tx;	

	$.get(url,function(res){

		var tabla=$("#tblDatos");

		$("#tblDatos tr").each(function(){
				$(this).remove();

			});
            for(var i=0;i<res.length;i++){
			var h="<tr>";
			h+="<td>"+res[i].idInmueble+"</td>";
			h+="<td>"+res[i].direccion+"</td>";
			h+="<td>"+res[i].precio+"</td>";
			h+="<td><a href='detalle.html?id="+res[i].idInmueble+"'> Ver Detalle</a> ";
			h+="<a href='#' onclick='evento("+res[i].idInmueble+")'>Detalle en ajax</a>";
			h+="<a href='modificarInmueble.html/"+res[i].idInmueble+"'> Modificar</a> ";
			h+="<a href='#' onclick='borrar("+res[i].idInmueble+")'>Borrar</a></td>";
			h+="</tr>";	
			tabla.append(h);
			}
    });

}
function evento(id){
  	var url="inmueble/"+id;
  	$.get(url,function(res){
var resultado="<ul>";
   resultado+="<li>"+ res.idInmueble+"<li>";
   resultado+="<li>"+ res.direccion+"<li>";
   resultado+="<li>"+ res.precio+"<li>";
   resultado+="<li>"+ res.propietario.nombre+"<li>";
   resultado+="<li>"+ res.inquilino.nombre+"<li>";
   $("#divDetalle").html(resultado);
  	});
	
}
</script>
</body>
</html>
