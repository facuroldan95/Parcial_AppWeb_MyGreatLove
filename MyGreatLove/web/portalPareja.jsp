<%-- 
    /*
     * "MyGreatLove"
     * JSP portalPareja.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portal Pareja</title>
        <%@include file="navbar.jsp" %>
    </head>
    <style>
        body {
            background-image: linear-gradient(rgba(0,0,0,0.5),rgba(0,0,0,0.5)),url('https://i.ibb.co/JkKKhgK/wallpaperflare-com-wallpaper.jpg');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: cover;
        }

        .padre {
            background: yellow;
            height: 150px;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .hijo {
            background: red;
            width: 120px;
        }



    </style>
    <body>
        <c:choose>
            <c:when test="${ not empty usr}">
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="CrearCuenta" class="border p-5 form facundo" method="post" id='form' style="background: #ffffff">
                            <h1 class="align-content-lg-between">Datos de la Pareja</h1>
                            <div class="form-group">
                                <a>Miembros</a>
                                <h2 class="alert alert-success">${Conyugue1} y ${Conyugue2}</h2>
                                <br>
                                <a>Cantidad de Regalos</a>
                                <h2 class="alert alert-warning">${CantidadRegalos}</h2>
                                <br>
                                <a>Fondos</a>
                                <h2 class="alert alert-danger">$${infoPareja.monto}</h2>
                                <br>
                                <a>Codigo de Invitacion</a>
                                <h2 class="alert alert-info">Nº${infoPareja.idPareja}</h2>
                                <br>
                            </div>

                            <br>
                            <span class="label label-warning">Has iniciado sesión como <b>${usr}</b></span>
                            <br>
                            <a class="btn btn-primary" href="Articulos">Comprar Articulos</a>
                            <a class="btn btn-primary" href="ListadoOperaciones.jsp">Listado de Operaciones</a>
                            <br><br>
                            <a class="btn btn-primary" href="ListadoDepositos.jsp">Listado de Depositos</a>
                            <a class="btn btn-primary" href="Login?modo=logout">Salir</a>
                            <p class="warnings" id="warnings"></p>
                    </div>

                </form>
            </div>
        </div>       
    </c:when>
    <c:otherwise>
        <%@include file="error.jsp" %>
    </c:otherwise>
</c:choose>

</body>
</html>
