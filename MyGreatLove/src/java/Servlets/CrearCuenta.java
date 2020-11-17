/*
 * "MyGreatLove"
 * Servlet CrearCuenta.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import Gestores.DBConyugue;
import Gestores.DBCuentas;
import Gestores.DBParejas;
import Modelos.Conyugue;
import Modelos.Cuenta;
import Modelos.Pareja;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author facut
 */
public class CrearCuenta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String validarConyugues = (String) request.getSession().getAttribute("altaConyugue");

        if (validarConyugues != null && !validarConyugues.equals("")) {
            RequestDispatcher rd = request.getRequestDispatcher("/crearcuenta.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession misession = (HttpSession) request.getSession();
        //int dni_01 = (int)request.getSession().getAttribute("dni_1");
        //int dni_02 = (int)request.getSession().getAttribute("dni_2");
        boolean validar = false;

        Conyugue conyugue1 = (Conyugue) misession.getAttribute("Conyugue1");
        Conyugue conyugue2 = (Conyugue) misession.getAttribute("Conyugue2");

        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        String cpassword = request.getParameter("txtCPassword");

        if (password.equals(cpassword)) {
            boolean existe = false;

            DBParejas gestorPareja = new DBParejas();
            DBCuentas gestorCuenta = new DBCuentas();
            DBConyugue gestorConyugue = new DBConyugue();

            ArrayList<Cuenta> listaCuentas = gestorCuenta.ObtenerCuentas();

            for (Cuenta listaCuenta : listaCuentas) {
                if (listaCuenta.getUsuario().equals(usuario)) {
                    request.setAttribute("mensajeError", "Ya existe una cuenta con este usuario...");
                    existe = true;
                }
            }

            if (!existe) {
                int idCuenta = -1;
                Cuenta cuenta = new Cuenta();

                cuenta.setUsuario(usuario);
                cuenta.setPassword(password);
                cuenta.setAdmin(false);
                cuenta.setEstado(true);

                gestorCuenta.AgregarCuenta(cuenta);

                ArrayList<Cuenta> lc = gestorCuenta.ObtenerCuentas();
                for (Cuenta c : lc) {
                    if (c.getUsuario().equals(usuario)) {
                        idCuenta = c.getIdCuenta();
                    }
                }

                //Pareja pareja = new Pareja(0, true, idCuenta);
                Pareja pareja = new Pareja();
                pareja.setEstado(true);
                pareja.setIdCuenta(idCuenta);
                pareja.setMonto(0);

                gestorPareja.AgregarPareja(pareja);

                int idPareja = gestorPareja.localizarPareja(idCuenta);
                if (idPareja >= 0) {
                    gestorConyugue.AgregarConyugue(conyugue1);
                    gestorConyugue.AgregarConyugue(conyugue2);
                    gestorConyugue.AgregarPareja(conyugue1.getDni(), idPareja);
                    gestorConyugue.AgregarPareja(conyugue2.getDni(), idPareja);
                    //misession.invalidate();
                    validar = true;

                }
            }

            if (validar) {
                misession.invalidate();
                request.getSession().setAttribute("CuentaCreada", "validar");
                request.getSession().setAttribute("ErrorCuenta", null);
                response.sendRedirect(getServletContext().getContextPath() + "/CuentaCreada.jsp");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/AltaCuenta.jsp");
                rd.forward(request, response);
            }
        }
        else{
            request.getSession().setAttribute("CuentaCreada", null);
            request.getSession().setAttribute("ErrorCuenta", "validar");
            response.sendRedirect(getServletContext().getContextPath() + "/CuentaCreada.jsp");
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
