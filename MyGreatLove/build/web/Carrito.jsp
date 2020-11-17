<%-- 
    /*
     * "MyGreatLove"
     * JSP Carrito.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito de compras</title>

        <%@include file="navbar.jsp" %>
        <c:choose>
            <c:when test="${ not empty usr}">
            </head> 
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <form action="ComprarArticulo" class="border p-5 form facundo" method="post" id='form'>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Articulo</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Carrito}" var="item">
                                    <tr>
                                        <td>${item.articulo}</td>
                                        <td>${item.auxCant}</td>
                                        <td>${item.precio * item.auxCant}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <button type="submit" class="btn btn-primary btn-md mr-1 mb-2" name="action" value="terminar">Comprar</button>

                        <p class="warnings" id="warnings"></p>
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