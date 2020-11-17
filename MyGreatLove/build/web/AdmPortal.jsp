<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmPortal.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adm - Portal</title>
        <%@include file="navbar.jsp" %>
    </head>
    <body>
        <c:choose>
            <c:when test="${ not empty usr and not empty ModoAdmin}">
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="CrearCuenta" class="border p-5 form facundo" method="post" id='form' style="background: #ffffff">
                            <h1 class="align-content-lg-between">Panel Adminsitrativo</h1>
                            <br>
                            <div class="form-group">
                                <br>
                                <h4>Listado de Parejas</h4>
                                <h2><a class="btn btn-primary" href="Administracion?funcion=listadoCuentas">Administrar</a></h2>
                                <br>
                                <h4>Listado de Operaciones</h4>
                                <h2><a class="btn btn-primary" href="Administracion?funcion=listadoOperaciones">Visualizar</a></h2>
                                <br>
                                <h4>Top 5 Ventas</h4>
                                <h2><a class="btn btn-primary" href="Administracion?funcion=top5">Visualizar</a></h2>
                                <br>
                                <h4>Agregar Articulos</h4>
                                <h2><a class="btn btn-primary" href="CargarArticulo?modo=alta">Agregar</a></h2>
                                <br>
                            </div>

                            <br>
                            <span class="label label-warning">Has iniciado sesión como <b>${usr}</b></span>
                            <br>
                            <a class="btn btn-primary" href="Login?modo=logout">Salir</a>
                            <p class="warnings" id="warnings"></p>
                    </div>
                </form>
            </div>
        </div>       
    </c:when>
    <c:otherwise>
        <%@include file="SeccionAdministrador.jsp" %>
    </c:otherwise>
</c:choose>

</body>
</html>
</html>
