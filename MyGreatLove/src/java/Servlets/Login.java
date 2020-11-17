/*
 * "MyGreatLove"
 * Servlet Login.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import Gestores.DBCuentas;
import Modelos.Cuenta;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author facut
 */
public class Login extends HttpServlet {

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

        String modo = request.getParameter("modo");

        if (modo != null && !modo.equals("")) {
            if (modo.equals("logout")) {
                request.getSession().invalidate();
                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);
            }
        }

        /*

         */
        RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
        rd.forward(request, response);
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
        DBCuentas gestor = new DBCuentas();
        ArrayList<Cuenta> Cuentas = gestor.ObtenerCuentas();
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        boolean login = false;

        for (Cuenta cuenta : Cuentas) {
            if (cuenta.getUsuario().equals(usuario) && cuenta.getPassword().equals(password)) {
                if (cuenta.isEstado()) {
                    login = true;
                    request.getSession().setAttribute("usr", usuario);
                    if (cuenta.isAdmin()) {
                        request.getSession().setAttribute("ModoAdmin", "enabled");
                    }
                    response.sendRedirect(getServletContext().getContextPath() + "/Portal");
                } else {
                    request.setAttribute("MensajeError", "Cuenta suspendida, contacte a un administrador.");
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                }

            }
            request.setAttribute("MensajeError","Usuario o contraseña incorrecta.");
        }

        if (!login) {
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
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
