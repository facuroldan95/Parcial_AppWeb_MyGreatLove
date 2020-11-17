/*
 * "MyGreatLove"
 * Servlet Articulos.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import Gestores.DBArticulos;
import Gestores.DBTipoArticulos;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sumit
 */
public class Articulos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

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
        //processRequest(request, response);
        DBArticulos gestorArticulos = new DBArticulos();
        DBTipoArticulos gestorTipoArticulos = new DBTipoArticulos();
        String usuario = (String) request.getSession().getAttribute("usr");
        String admin = (String) request.getSession().getAttribute("ModoAdmin");
        String idTipoCategoria = (String) (request.getParameter("idCategoria"));

        if (usuario != null && !usuario.equals("")) {
            if (idTipoCategoria != null) {
                if (admin != null && !admin.equals("")) {
                    request.setAttribute("listaArticulos", gestorArticulos.ObtenerArticulosPorCategoriaAdmin(Integer.parseInt(idTipoCategoria)));
                } else {
                    request.setAttribute("listaArticulos", gestorArticulos.ObtenerArticulosPorCategoriaNormal(Integer.parseInt(idTipoCategoria)));
                }
            } else {
                if (admin != null && !admin.equals("")) {
                    request.setAttribute("listaArticulos", gestorArticulos.ObtenerArticulos());
                } else {
                    request.setAttribute("listaArticulos", gestorArticulos.ObtenerArticulosPorEstado(true));
                }
                
            }
            request.setAttribute("tipoArticulos", gestorTipoArticulos.ObtenerTipoArticulos());
            RequestDispatcher rd = request.getRequestDispatcher("/Articulos.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/Login");
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
        //processRequest(request, response);
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
