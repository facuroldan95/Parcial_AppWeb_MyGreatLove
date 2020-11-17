<%-- 
    /*
     * "MyGreatLove"
     * JSP navbar.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <style>
            body{
                font-family:"Century Gothic" Geneva Helvetica, sans-serif;
                background: url('images/bg.png');         
            }
            .facundo{
                background: #ffffff; 
                border: black;
                border-style: solid;
                border-width: 5px;

            }

        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar navbar navbar-dark bg-dark" >
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
                <a class="navbar-brand" href="#" >My Great Love</a>
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
                    <li class="nav-item ">
                        <a class="nav-link" href="index.jsp">Inicio</a>
                    </li>
                    <c:choose>
                        <c:when test="${empty usr}">
                            <li class="nav-item ">
                                <a class="nav-link" href="Regalo">Enviar Regalo</a>
                            </li> 

                        </c:when>

                    </c:choose>
                    <c:choose>
                        <c:when test="${not empty usr}">
                            <li class="nav-item">
                                <a class="nav-link" href="Articulos">Articulos</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="Portal">Portal</a>
                            </li>
                        </ul>
                        <form class="form-inline my-2 my-lg-0">
                            <a class="btn btn-primary" href="Login?modo=logout">Cerrar Sesión</a>
                        </form>
                    </c:when>

                    <c:otherwise>
                        </ul>
                        <form class="form-inline my-2 my-lg-0">
                            <a class="btn btn-primary" href="Login">Ingresar</a>
                            <a class="btn btn-success" href="AltaPareja">Registrarse </a>
                        </form>
                    </c:otherwise>
                </c:choose>
            </div>
        </nav>
    </body>
</html>
