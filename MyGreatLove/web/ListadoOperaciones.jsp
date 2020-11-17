<%-- 
    /*
     * "MyGreatLove"
     * JSP ListadoOperaciones.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Operaciones</title>
    <%@include file="navbar.jsp" %>
        <c:choose>
            <c:when test="${ not empty usr}">
            </head> 
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <div class="border p-5 form facundo">
                        <h3>Datos de tus operaciones</h3>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Articulo</th>
                                    <th scope="col">Precio Unitario</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Monto</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Operaciones}" var="item">
                                    <tr>
                                        <td>${item.idOperacion}</td>
                                        <td>${item.articulo}</td>
                                        <td>${item.precioUnitario}</td>
                                        <td>${item.cantidad}</td>
                                        <td>${item.montoTotal}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h3 class="alert alert-danger" role="alert">Total Gastado $ ${MontoTotal}</h3>
                    </div>
                </div>
            </div>       
        </c:when>
        <c:otherwise>
            <%@include file="error.jsp" %>
        </c:otherwise>
    </c:choose>


</body>
</html>