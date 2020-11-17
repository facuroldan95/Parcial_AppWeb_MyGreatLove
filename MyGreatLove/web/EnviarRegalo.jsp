<%-- 
    /*
     * "MyGreatLove"
     * JSP EnviarRegalo.
     * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
     */
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Regalo Enviado Con Exito</title>
        <%@include file="navbar.jsp" %>
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center" style="margin-top: 40px">
                <form action="Regalo" class="border p-5 form facundo" method="post" id='form'>
                    <h1 class="align-content-lg-between">Enviar Regalo</h1>
                    <div class="form-group">
                        <label for="text">Nombre Completo</label>
                        <input type="text" name="txtInvitado" id="txtNombre" class="form-control">                         
                    </div>
                    <div class="form-group">
                        <label for="text">Ingrese Monto a Regalar</label>
                        <input type="number" name="txtMonto" id="txtMonto" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="text">Codigo de Invitación</label>
                        <input type="number" name="txtInvitacion" id="txtInvitacion" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="text">Nº Tarjeta</label>
                        <input type="text" name="txtTarjeta" id="txtTarjeta" class="form-control" maxlength="16" onkeypress="return solonumeros(event)">
                    </div>
                    <div class="form-group">
                        <label for="text">DNI Titular</label>
                        <input type="text" name="txtDNI" id="txtDNI2" class="form-control" maxlength="8" onkeypress="return solonumeros(event)">
                    </div>
                    <br>
                    <button type="submit" class="btn btn-primary">Ingresar</button>
                    <p class="warnings" id="warnings"></p>
            </div>

        </form>
    </div>
</div>
</body>

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
</html>
