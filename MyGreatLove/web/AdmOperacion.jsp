<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmOperacion.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adm - Operación</title>
        <%@include file="navbar.jsp" %>
            </head> 
            <c:choose>
            <c:when test="${ not empty usr and not empty ModoAdmin}">
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <div class="border p-5 form facundo">
                        <h3>Datos de Operacion #${AdmOperacionIdOp} </h3>
                        <a>Correspondiente a <a style="color: red">${AdmOperacionUsuario}</a> en la fecha <a style="color:red">${AdmOperacionFecha}</a></a>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Articulo</th>
                                    <th scope="col">Precio</th>
                                    <th scope="col">Cantidad</th>
                                    <th scope="col">Monto Total</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${AdmOperacion}" var="item">
                                    <tr>
                                        <td>${item.articulo}</td>
                                        <td>${item.precioUnitario}</td>
                                        <td>${item.cantidad}</td>
                                        <td>${item.montoTotal}</td>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h4 class="alert alert-info">Suma Total de Operaciones: ${AdmOperacionFacturado}</h4>
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