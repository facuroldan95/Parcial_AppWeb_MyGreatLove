/*
 * "MyGreatLove"
 * Servlet Portal.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import DTOs.DetalleOperacion;
import Gestores.DBConyugue;
import Gestores.DBDepositos;
import Gestores.DBOperaciones;
import Gestores.DBParejas;
import Modelos.Conyugue;
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
public class Portal extends HttpServlet {

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
        String usuario = (String) request.getSession().getAttribute("usr");
        String admin = (String) request.getSession().getAttribute("ModoAdmin");

        if(admin != null) {
            RequestDispatcher rd = request.getRequestDispatcher("AdmPortal.jsp");
            rd.forward(request, response);
        } else {
            DBParejas gestorParejas = new DBParejas();
            DBConyugue gestorConyugues = new DBConyugue();
            DBDepositos gestorDepositos = new DBDepositos();
            DBOperaciones gestorOperaciones = new DBOperaciones();

            request.getSession().setAttribute("infoPareja", gestorParejas.ObtenerInformacionPareja(usuario));
            request.getSession().setAttribute("DepositosTotales", gestorDepositos.ObtenerMontoDepositosDeUnaPareja(gestorParejas.ObtenerInformacionPareja(usuario).getIdPareja()));
            request.setAttribute("CantidadRegalos", gestorDepositos.ObtenerCantidadDepositosDeUnaPareja(gestorParejas.ObtenerInformacionPareja(usuario).getIdPareja()));
            request.getSession().setAttribute("Operaciones", gestorOperaciones.ObtenerOperaciones(gestorParejas.ObtenerInformacionPareja(usuario).getIdPareja()));
            request.getSession().setAttribute("Depositos", gestorDepositos.ListadoDepositos(gestorParejas.ObtenerInformacionPareja(usuario).getIdPareja()));
            ArrayList<Conyugue> miembros = gestorConyugues.ObtenerConyuguesDeUnaPareja(gestorParejas.ObtenerInformacionPareja(usuario).getIdPareja());
            double gastoTotal = 0;

            ArrayList<DetalleOperacion> listaOperaciones = gestorOperaciones.ObtenerOperaciones(gestorParejas.ObtenerInformacionPareja(usuario).getIdPareja());
            for (DetalleOperacion listaOperacione : listaOperaciones) {
                gastoTotal += listaOperacione.getMontoTotal();
            }
            request.getSession().setAttribute("MontoTotal", gastoTotal);
            String miembro1 = miembros.get(0).getNombre();
            String miembro2 = miembros.get(1).getNombre();

            request.setAttribute("Conyugue1", miembro1);
            request.setAttribute("Conyugue2", miembro2);

            RequestDispatcher rd = request.getRequestDispatcher("/portalPareja.jsp");
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
