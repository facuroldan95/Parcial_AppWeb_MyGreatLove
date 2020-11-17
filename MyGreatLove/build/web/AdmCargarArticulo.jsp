<%-- 
    /*
     * "MyGreatLove"
     * JSP AdmCargarArticulo.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Modelos.Articulo"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Adm - Cargar Articulo</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="navbar.jsp" %>
    </head>
    <c:choose>
        <c:when test="${ not empty usr and not empty ModoAdmin}">
            <body>
                <div class="container">
                    <div class="d-flex justify-content-center" style="margin-top: 40px">
                        <form action="CargarArticulo" class="border p-5 form facundo" method="post" id='form'>
                            <input type="hidden" name="txtIdArticulo" id="txtIdArticulo" value="${modeloArticulo.idArticulo}" />
                            <h1 class="align-content-lg-between">Cargar Articulo</h1>
                            <div class="form-group">
                                <label for="text">Nombre del Articulo</label>
                                <input type="text" name="txtArticulo" id="txtArticulo" class="form-control" value="${modeloArticulo.articulo}">                         
                            </div>
                            <div class="form-group">
                                <label for="text">Categoría</label>
                                <br>
                                <select name = cmbTipoArticulo>
                                    <c:forEach items="${tipoArticulos}" var="item">
                                        <option value="${ item.idTipoArticulo }" <c:if test="${ item.idTipoArticulo == modeloArticulo.idTipoArticulo }">selected</c:if>>  ${ item.tipo }</option>
                                    </c:forEach>
                                </select>

                            </div>
                            <div class="form-group">
                                <label for="text">Precio</label>
                                <input type="number" name="txtPrecio" id="txtPrecio" class="form-control" value="${modeloArticulo.precio}">
                            </div>
                            <div class="form-group">
                                <label for="text">Cantidad</label>
                                <input type="number" name="txtCantidad" id="txtCantidad" class="form-control" value="${modeloArticulo.cantidad}">
                            </div>
                            <div class="form-group">
                                <label for="text">Link Imagen</label>
                                <input type="text" name="txtImagen" id="txtImagen" class="form-control" value="${modeloArticulo.linkImagen}">                         
                            </div>
                            <div class="form-group">
                                <label for="text">Promocion:</label>
                                <input type="checkbox" name="chkPromocion" id="chkPromocion" value="">                                 
                            </div>
                            <div class="form-group">
                                <label for="text">Descripcion:</label><br>
                                <textarea name="txtDescripcion" id="txtDescripcion" rows="10" cols="40">${modeloArticulo.descripcion}</textarea>                            
                            </div>
                            <br>
                            <button type="submit" class="btn btn-primary">Registrar Producto</button>
                            <p class="warnings" id="warnings"></p>
                    </div>
                </form>
            </div>
        </body>
    </c:when>
    <c:otherwise>
        <%@include file="SeccionAdministrador.jsp" %>
    </c:otherwise></c:choose>
</html>
