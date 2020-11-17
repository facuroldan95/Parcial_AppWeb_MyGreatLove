<%-- 
    Document   : ListadoDepositos
    Created on : 09-nov-2020, 11:33:32
    Author     : sumit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listado de Depositos</title>
        <%@include file="navbar.jsp" %>
        <c:choose>
            <c:when test="${ not empty usr}">
            </head> 
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <div class="border p-5 form facundo">
                        <h3>Datos de los Depositos</h3>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">Fecha</th>
                                    <th scope="col">Dni</th>
                                    <th scope="col">Invitado</th>
                                    <th scope="col">Deposito</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${Depositos}" var="item">
                                    <tr>
                                        <td>${item.fecha}</td>
                                        <td>${item.dni}</td>
                                        <td>${item.invitado}</td>
                                        <td>${item.monto}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h3 class="alert alert-danger" role="alert">Total Recibido $ ${DepositosTotales}</h3>
                    </div>
                </div>
            </div>       
        </c:when>
        <c:otherwise>
            <%@include file="error.jsp" %>
        </c:otherwise>
    </c:choose>