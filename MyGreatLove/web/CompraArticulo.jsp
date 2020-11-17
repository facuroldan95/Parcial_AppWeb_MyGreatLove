<%-- 
    /*
     * "MyGreatLove"
     * JSP CompraArticulo.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articulos - Comprar</title>
        <%@include file="navbar.jsp" %>
        <script src="js/love.js"></script>
    </head>
    <body>
        <form action="ComprarArticulo" method="post" id="form">
            <section class="mb-5 facundo">
                <input type="hidden" name="txtIdArticulo" id="txtIdArticulo" value="${modeloArticulo.idarticulo}" />
                <input type="hidden" name="txtStock" id="txtStock" value="${modeloArticulo.cantidad}" />
                <input type="hidden" name="txtMonto" id="txtMonto" value="${modeloArticulo.precio}" />
                <div class="row">
                    <div class="col-md-6 mb-4 mb-md-0">

                        <div id="mdb-lightbox-ui"></div>

                        <div class="mdb-lightbox">

                            <div class="row product-gallery mx-1">

                                <div class="col-12 mb-0">
                                    <figure class="view overlay rounded z-depth-1 main-img">
                                        <a href="${modeloArticulo.linkImagen}"
                                           data-size="200x187">
                                            <img src="${modeloArticulo.linkImagen}"
                                                 class="img-fluid z-depth-1">
                                        </a>
                                    </figure>

                                </div>

                            </div>

                        </div>

                    </div>
                    <div class="col-md-6">

                        <h2>${modeloArticulo.articulo}</h2>
                        <p class="mb-2 text-muted text-uppercase small">${modeloArticulo.categoria}</p>

                        <h3><span class="mr-1"><strong>$ ${modeloArticulo.precio}</strong></span></h3>
                        <p><span class="mr-1">Stock: ${modeloArticulo.cantidad}</span></p>
                        <p class="pt-1">${modeloArticulo.descripcion}</p>
                        <hr>
                        <label>Cantidad:</label>
                        <input type="number" name="txtCantidad" id="txtCantidad" style="width: 50px" value="1">
                        <c:if test="${ not empty mensajeError}">    
                        <p class="alert alert-danger">${mensajeError}</p>
                        </c:if>
                        <br>
                        <br>
                        <button type="submit" class="btn btn-primary btn-md mr-1 mb-2" name="action" value="comprar">Comprar Ahora</button>
                        <button type="submit" class="btn btn-light btn-md mr-1 mb-2" name="action" value="carrito"><i
                                class="fas fa-shopping-cart pr-2"></i>Agregar Al Carrito</button>
                    </div>
                </div>

            </section>
        </form>
    </body>
</html>
