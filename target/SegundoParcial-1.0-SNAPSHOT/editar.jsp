<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
        
        
        <h1 align="center">
            <c:if test="${productos.id==0}">
                Nuevo Registro de Producto
            </c:if>
            <c:if test="${productos.id!=0}">
                Editar Registro de Producto
            </c:if>
        </h1>
        <form action="Main" method="post">
            <input type="hidden" name="id" value="${productos.id}">
            <table align="center">
                <tr>
                    <td>Descripción:</td>
                    <td><input type="text" name="descripcion" value="${productos.descripcion}"></td>
                </tr>
                
                <tr>
                    <td>Cantidad:</td>
                    <td><input type="number" name="cantidad" value="${productos.cantidad}"></td>
                </tr>
                
                <tr>
                    <td>Precio:</td>
                    <td><input type="number" name="precio" value="${productos.precio}" step="0.1"></td>
                    <td>bs.</td>
                </tr>
                
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categoria" value="${productos.categoria}"></td>
                </tr>
                <tr>
                    <td>   </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="<c:if test="${productos.id==0}">Enviar</c:if><c:if test="${productos.id!=0}">Actualizar</c:if>"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
