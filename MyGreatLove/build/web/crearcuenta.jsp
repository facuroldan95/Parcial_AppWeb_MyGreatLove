<%-- 
    /*
     * "MyGreatLove"
     * JSP crearcuenta.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear cuenta...</title>
            <%@include file="navbar.jsp" %>

        </head> 
        <c:choose>
            <c:when test="${ not empty altaConyugue}">
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="CrearCuenta" class="border p-5 form facundo" method="post" id='form'>
                            <h1 class="align-content-lg-between" style='margin-left: 60px'>Alta Usuario</h1>
                        <div class="form-group">
                          <label for="text">Usuario</label>
                          <input type="text" name="txtUsuario" id="txtUsuario" class="form-control">
                          <% if(request.getAttribute("mensajeError") != null && !request.getAttribute("mensajeError").equals("")){ %>
                        <p class="alert alert-danger">${mensajeError}</p>
                          <% } %>
                        </div>
                        <div class="form-group">
                          <label for="text">Password</label>
                          <input type="password" name="txtPassword" id="txtPassword" class="form-control">
                        </div>
                        <div class="form-group">
                          <label for="text">Confirmar Password</label>
                          <input type="password" name="txtCPassword" id="txtCPassword" class="form-control">
                        </div>

                          <br>
                          <button type="submit" class="btn btn-primary">Registrar</button>
                            <p class="warnings" id="warnings"></p>
                        </div>

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