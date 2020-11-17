<%-- 
    /*
     * "MyGreatLove"
     * JSP SinStock.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR</title>
        <%@include file="navbar.jsp"%>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty usr}">
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="Login" class="border p-5 form facundo" method="post" id='form'>
                            <h1 class="align-content-lg-between">Stock insuficiente</h1>
                            <p>No hay suficiente stock en alguno de los productos seleccionados.</p>
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
