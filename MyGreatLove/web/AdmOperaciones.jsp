<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmOperaciones.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adm - Listado de Operaciones</title>
        <%@include file="navbar.jsp" %>
            </head> 
            <c:choose>
            <c:when test="${ not empty usr and not empty ModoAdmin}">
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <div class="border p-5 form facundo">
                        <h3>Datos de Operaciones</h3>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">ID Operacion</th>
                                    <th scope="col">Facturado</th>
                                    <th scope="col">Monto Total</th>
                                    <th scope="col">Visualisación</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${AdmOperaciones}" var="item">
                                    <tr>
                                        <td>${item.fecha}</td>
                                        <td>${item.idOperacion}</td>
                                        <td>${item.usuario}</td>
                                        <td>${item.montoTotal}</td>
                                        <td><a class="btn btn-primary" href="Administracion?funcion=VisualizarOperacion&id=${item.idOperacion}">Revisar</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h4 class="alert alert-info">Suma Total de Operaciones: ${AdmOperacionesMontoTotal}</h4>
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
