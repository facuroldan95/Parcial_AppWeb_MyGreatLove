<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmTop5Ventas.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adm - Top 5 Ventas</title>
        <%@include file="navbar.jsp" %>
    </head> 
    <c:choose>
        <c:when test="${ not empty usr and not empty ModoAdmin}">
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <div class="border p-5 form facundo">
                        <h3>Top de Ventas </h3>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Id Articulo</th>
                                    <th scope="col">Articulo</th>
                                    <th scope="col">Ventas</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Top5}" var="item">
                                    <tr>
                                        <td>${item.idArticulo}</td>
                                        <td>${item.articulo}</td>
                                        <td>${item.cantidad}</td>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>                    
                </div>
            </div>       
        </c:when>
        <c:otherwise>
            <%@include file="SeccionAdministrador.jsp" %>
        </c:otherwise>
    </c:choose>


</body>
</html>
