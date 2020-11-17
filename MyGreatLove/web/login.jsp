<%-- 
    /*
     * "MyGreatLove"
     * JSP login.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
        <%@include file="navbar.jsp"%>
    </head>
    <c:choose>
        <c:when test="${empty usr}">
            <body>
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="Login" class="border p-5 form facundo" method="post" id='form'>
                            <h1 class="align-content-lg-between">Iniciar Sesión</h1>
                            <div class="form-group">
                                <label for="text">Usuario</label>
                                <input type="text" name="txtUsuario" id="txtUsuario" class="form-control">                         
                            </div>
                            <div class="form-group">
                                <label for="text">Password</label>
                                <input type="password" name="txtPassword" id="txtPassword" class="form-control">
                            </div>
                            <c:if test="${ not empty MensajeError}">
                                <p class="alert alert-danger">${MensajeError}</p></c:if>
                                <br>
                                <button type="submit" class="btn btn-primary">Ingresar</button>
                                <p class="warnings" id="warnings"></p>
                        </div>
                    </form>
                </div>
            </div>
        </body>
</c:when>
<c:otherwise>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center" style="margin-top: 40px">
                <form action="Login" class="border p-5 form facundo" method="post" id='form'>
                    <h1 class="align-content-lg-between">Sesión Iniciada</h1>
                    <p>Ya iniciaste sesión.</p>
            </div>
        </form>
    </div>
</body>
</c:otherwise>
</c:choose>
</html>
