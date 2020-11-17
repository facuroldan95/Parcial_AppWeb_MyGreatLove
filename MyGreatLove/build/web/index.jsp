<%-- 
    /*
     * "MyGreatLove"
     * JSP index.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My GreatLove</title>
        <%@include file="navbar.jsp"%>
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center" style="margin-top: 40px">
                <form class="border p-5 form facundo" method="post" id='form'>
                    <h1 class="align-content-lg-between">Bienvenidos a MyGreatLove</h1><br><br>
                    <h4>Registrarse</h4>
                    <p>Para parejas, es necesario registrarse para poder usar el servicio.</p>
                    <h2><a class="btn btn-primary" href="AltaPareja">Registrarse</a></h2>
                    <br><br>
                    <h4>Iniciar Sesión</h4>
                    <p>Si ya estas registrado, por favor inicia sesión</p>
                    <h2><a class="btn btn-primary" href="Login">Iniciar Sesión</a></h2>
                    <br><br>
                    <h4>Invitados</h4>
                    <p>Si eres invitado y tienes el codigo de invitación, puedes depositar el regalo.</p>
                    <h2><a class="btn btn-primary" href="Regalo">Enviar Regalo</a></h2>
                    <br><br>
                    </div>
                </form>
            </div>
    </body>
</html>
