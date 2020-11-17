<%-- 
    /*
     * "MyGreatLove"
     * JSP altapareja.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <%@include file="navbar.jsp" %>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Alta conyugue...</title>
</head>
<div class="container">
    <div class="d-flex justify-content-center" style="margin-top: 40px">
        <form action="AltaPareja" class="border p-5 form facundo" method="POST" id='form'>
            <h1 class="align-content-lg-between" style='margin-left: 60px'>Alta Conyugue</h1>
            <br>
            <h4 class="align-content-lg-between" style='margin-left: 60px'>Datos del primer Conyugue</h1>
                <div class="form-group">
                    <label for="text">Nombre</label>
                    <input type="text" name="txtNombre" id="txtNombre" class="form-control ">
                </div>
                <div class="form-group">
                    <label for="text">Apellido</label>
                    <input type="text" name="txtApellido" id="txtApellido" class="form-control">
                </div>
                <div class="form-group">
                    <label for="text">DNI</label>
                    <input type="text" name="txtDNI" id="txtDNI" class="form-control" maxlength="8" onkeypress="return solonumeros(event)">
                </div>
                <br>
                <h4 class="align-content-lg-between" style='margin-left: 60px'>Datos del segundo Conyugue</h1>                
                    <div class="form-group">
                        <label for="text">Nombre</label>
                        <input type="text" name="txtNombre2" id="txtNombre2" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="text">Apellido</label>
                        <input type="text" name="txtApellido2" id="txtApellido2" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="text">DNI</label>
                        <input type="text" name="txtDNI2" id="txtDNI2" class="form-control" maxlength="8" onkeypress="return solonumeros(event)">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary" id="btn" style="width: 10.5cm">Registrar</button>
                    <p class="warnings" id="warnings"></p>
                    </form>

                    </div>
                    </div>




                    <script>
                        function solonumeros(e) {
                            key = e.keyCode || e.which;

                            teclado = String.fromCharCode(key);

                            numeros = '0123456789';

                            especiales = "8-37-38-46";

                            teclado_especial = false;

                            for (var i in especiales) {
                                if (key == especiales[i]) {
                                    teclado_especial = true
                                }
                            }

                            if (numeros.indexOf(teclado) == -1 && !teclado_especial) {
                                return false;
                            }
                        }
                    </script>    
                    </body>
                    </html>