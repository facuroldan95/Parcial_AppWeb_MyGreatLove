/*
 * "MyGreatLove"
 * Servlet Regalos.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import Gestores.DBDepositos;
import Gestores.DBParejas;
import Modelos.Deposito;
import Modelos.Pareja;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author facut
 */
public class Regalo extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("EnviarRegalo.jsp");
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
        String invitado = request.getParameter("txtInvitado");
        double monto = Double.parseDouble(request.getParameter("txtMonto"));
        int idPareja = Integer.parseInt(request.getParameter("txtInvitacion"));
        String tarjeta = request.getParameter("txtTarjeta");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String fecha = String.valueOf(formatter.format(date));

        Deposito dep = new Deposito();
        dep.setDni(dni);
        dep.setFecha(fecha);
        dep.setTarjeta(tarjeta);
        dep.setInvitado(invitado);
        dep.setIdPareja(idPareja);
        dep.setMonto(monto);
        

        DBDepositos gestorDepositos = new DBDepositos();
        DBParejas gestorParejas = new DBParejas();

        Pareja p = gestorParejas.ObtenerParejaPorId(idPareja);

        double suma = p.getMonto() + monto;

        gestorDepositos.AgregarDeposito(dep);
        gestorParejas.ModicicarSaldo(suma, idPareja);
        request.getSession().setAttribute("RegaloEnviado", monto);
        RequestDispatcher rd = request.getRequestDispatcher("/RegaloEnviado.jsp");
        rd.forward(request, response);

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
