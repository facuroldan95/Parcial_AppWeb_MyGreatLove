<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmParejasActualizar.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="DTOs.DTOCuenta"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adm - Actualizar Parejas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="navbar.jsp" %>
    </head>
    <c:choose>
        <c:when test="${ not empty usr and not empty ModoAdmin}">
            <body>
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="Administracion" class="border p-5 form facundo" method="post" id='form'>
                            <input type="hidden" name="txtIdCuenta" id="txtIdPareja" value="${Cuenta.idCuenta}" />
                            <input type="hidden" name="txtIdConyugue2" id="txtDni2" value="${Conyugues2.dni}"/>
                            <input type="hidden" name="txtIdConyugue1" id="txtIdConyugue1" value="${Conyugues1.dni}" />
                            <input type="hidden" name="txtIdPareja" id="txtIdPareja" value="${modeloPareja.idPareja}" />
                            <input type="hidden" name="txtIdCuenta" id="txtIdCuenta" value="${modeloPareja.idCuenta}" />
                            <h1 class="align-content-lg-between">Actualizar Pareja</h1>
                            <div class="form-group">
                                <label for="text">Nombre de los Conyugues </label><br>
                                <label for="text">Conyugue #1 </label>                        
                                <input type="text" name="txtConyugue1Nombre" id="txtConyugue1Nombre" class="form-control" value="${Conyugues1.nombre}">
                                <input type="text" name="txtConyugue1Apellido" id="txtConyugue1Apellido" class="form-control" value="${Conyugues1.apellido}">
                                <br>
                                <label for="text">Conyugue #2 </label>
                                <input type="text" name="txtConyugue2Nombre" id="txtConyugue2Nombre" class="form-control" value="${Conyugues2.nombre}">
                                <input type="text" name="txtConyugue2Apellido" id="txtConyugue2Apellido" class="form-control" value="${Conyugues2.apellido}">
                            </div>
                            <div class="form-group">
                                <label for="text">Usuario</label>
                                <input type="text" name="txtUsuario" id="txtUsuario" class="form-control" value="${Cuenta.usuario}">
                            </div>
                            <div class="form-group">
                                <label for="text">Contraseña</label>
                                <input type="password" name="txtClave" id="txtClave" class="form-control" value="${Cuenta.password}">
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary" name="action" value="updatep">Cargar</button>
                            <a class="btn btn-light" href="Administracion?funcion=listadoCuentas">Volver</a>
                            <p class="warnings" id="warnings"></p>
                    </div>
                </form>
            </div>
        </body>
    </c:when>
    <c:otherwise>
        <%@include file="SeccionAdministrador.jsp" %>
    </c:otherwise></c:choose>
</html>
