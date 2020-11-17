<%-- 
    /*
     * "MyGreatLove"
     * JSP CuentaCreada.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuenta Creada</title>
        <%@include file="navbar.jsp"%>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty CuentaCreada}">
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="Login" class="border p-5 form facundo" method="post" id='form'>
                            <h1 class="align-content-lg-between">Cuenta creada con exito</h1>
                            <p>Por favor <a class="btn btn-primary" href="Login">Inicia Sesión</a> para comenzara a usar el servicio. </p>
                    </div>
                </form>
            </div>
        </c:when>
            <c:when test="${not empty ErrorCuenta}">
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="Login" class="border p-5 form facundo" method="post" id='form'>
                            <h1 class="align-content-lg-between">Error al crear la cuenta</h1>
                            <p>Las contraseñas ingresadas no coinciden, por favor vuelva a intentarlo.</p>
                    </div>
                </form>
            </div>
                
            </c:when>
            <c:otherwise>
                <%@include file="error.jsp" %>
            </c:otherwise>
    </c:choose>
</body>
</html>
