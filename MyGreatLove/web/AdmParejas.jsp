<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmParejas.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adm - Parejas</title>
        <%@include file="navbar.jsp" %>
            </head> 
            <c:choose>
            <c:when test="${ not empty usr and not empty ModoAdmin}">
            <div class="container">
                <div class="d-flex justify-content-center" style="margin-top: 40px">
                    <div class="border p-5 form facundo">
                        <h3>Datos de Parejas</h3>
                        <table class="table table-bordered table-dark">
                            <thead>
                                <tr>
                                    <th scope="col">ID Cuenta</th>
                                    <th scope="col">ID Pareja</th>
                                    <th scope="col">Miembros</th>
                                    <th scope="col">Usuario</th>
                                    <th scope="col">Monto</th>
                                    <th scope="col">Cant Dep.</th>
                                    <th scope="col">Controles Administrativos</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${CuentasAdm}" var="item">
                                    <tr>
                                        <td>${item.idCuenta}</td>
                                        <td>${item.idPareja}</td>
                                        <td><c:forEach items="${item.conyugues}" var="item2">
                                                | ${item2.nombre} ${item2.apellido} |
                                            </c:forEach></td>
                                        <td>${item.usuario}</td>
                                        <td>${item.monto}</td>
                                        <td>${item.cantidadRegalos}</td>
                                        <td><a class="btn btn-primary" href="Administracion?funcion=update&user=${item.usuario}">Editar</a>
                                            <c:choose>
                                            <c:when test="${item.estado}">
                                                <a class="btn btn-danger" href="Administracion?funcion=estado&Activado=false&id=${item.idCuenta}">Dar Baja</a>
                                            </c:when>
                                            <c:otherwise>
                                                <a class="btn btn-success" href="Administracion?funcion=estado&Activado=true&id=${item.idCuenta}">Dar Alta</a>
                                            </c:otherwise>
                                                </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <h1 class="alert alert-info">Suma Total de Depositos: ${MontoTotalDepositos}</h1>
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
