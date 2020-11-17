<%-- 
    /*
     * "MyGreatLove"
     * JSP Articulos.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Articulos</title>
        <%@include file="navbar.jsp" %>
    </head>
    <c:choose>
        <c:when test="${not empty usr}">
            <body>
                <div class="container">

                    <div class="row">

                        <div class="col-lg-3">

                            <h1 class="my-4">My Great Love Shop</h1>
                            <div class="list-group">
                                <c:forEach items="${tipoArticulos}" var="item">
                                    <a href="Articulos?idCategoria=${item.idTipoArticulo}" class="list-group-item">${item.tipo}</a>
                                </c:forEach>
                                    <a href="Articulos" class="list-group-item">Mostrar Todos</a>
                            </div>
                            <c:if test="${empty ModoAdmin}">
                                <a class="btn btn-primary" href="Carrito.jsp">Ver Carrito de Compras</a>
                            </c:if>
                        </div>
                        <!-- /.col-lg-3 -->

                        <div class="col-lg-9">

                            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner" role="listbox">
                                    <div class="carousel-item active">
                                        <img class="d-block img-fluid" src="https://cdn.pp.slimpay.com/blog/2017/06/07122118/DZN-Blog-Hero-900x350-5KPIs.jpg" alt="First slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block img-fluid" src="https://previews.123rf.com/images/genestro/genestro1707/genestro170700027/82829150-banner-de-tienda-en-l%C3%ADnea-tienda-de-icono-de-construcci%C3%B3n-compras-en-l%C3%ADnea-de-comestibles-cesta-de-la-compr.jpg" alt="Second slide">
                                    </div>
                                    <div class="carousel-item">
                                        <img class="d-block img-fluid" src="https://cdn.pp.slimpay.com/blog/2018/09/18120232/DZN-Blog-Hero-900x350-CardTech.jpg" alt="Third slide">
                                    </div>
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>


                            <div class="row">
                                <c:forEach items="${listaArticulos}" var="item">
                                    <div class="col-lg-4 col-md-6 mb-4">
                                        <div class="card h-100">
                                            <a href="ComprarArticulo?modo=buy&id=${item.idArticulo}"><img class="card-img-top" src="${item.linkImagen}" alt=""></a>
                                            <div class="card-body">
                                                <h4 class="card-title">
                                                    <a href="ComprarArticulo?modo=buy&id=${item.idArticulo}">${item.articulo}</a>
                                                </h4>
                                                <h5>${item.precio}</h5>
                                                <p class="card-title">Cantidad: ${item.cantidad}</p>
                                                <p class="card-text">${item.descripcion}</p>
                                                <c:if test="${not empty ModoAdmin}">
                                                <a class="btn btn-primary" href="CargarArticulo?modo=actualizar&id=${item.idArticulo}">Editar</a>
                                                </c:if>
                                                <c:if test="${empty ModoAdmin}">
                                                <a class="btn btn-primary" href="ComprarArticulo?modo=buy&id=${item.idArticulo}">Comprar</a>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>



                            </div>
                            <!-- /.row -->

                        </div>
                        <!-- /.col-lg-9 -->

                    </div>
                    <!-- /.row -->

                </div>
            </c:when>
            <c:otherwise>
                <%@include file="error.jsp" %>
            </c:otherwise>
        </c:choose>
        <!-- /.container -->


        <!-- Bootstrap core JavaScript -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>

</html>
