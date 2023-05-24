<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Productos> productos =(List<Productos>)request.getAttribute("productos");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <table align="center">
            <tr>
                <td>
            <fieldset style="width:300px" style="align: center;">
                <p align="center">SEGUNDO PARCIAL TEM - 742</p>
                <p>Nombre: Josue Vidal Aruquipa Quispe<br>
                    Carnet: 6056889</p>
            </fieldset>
                </td>
            </tr>
        </table>
        
        <h1 align="center">Gestion de productos</h1>
        <div align="center">
        <button><a href="Main?action=add">Nuevo producto</a></button>
        </div>
        <br>
        <table border="1" align="center">
            <tr align="center">
                <th>Id</th>
                <th>Descripción</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            
            <c:forEach var="item" items="${productos}">
            
            <tr align="center">
                <td>${item.id}</td>
                <td>${item.descripcion}</td>
                <td>${item.cantidad}</td>
                <td>${item.precio} bs.</td>
                <td>${item.categoria}</td>
                <th>
                    <a href="Main?action=edit&id=${item.id}">Editar</a>
                </th>
                <th>
                    <a href="Main?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro de eliminar el registro?'))">Eliminar</a>
                </th>
            </tr>
            
            </c:forEach>
        </table>
    </body>
</html>
