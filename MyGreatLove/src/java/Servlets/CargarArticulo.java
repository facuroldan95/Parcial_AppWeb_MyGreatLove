/*
 * "MyGreatLove"
 * Servlet CargarArticulo.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import Modelos.TipoArticulo;
import Modelos.Articulo;
import Gestores.DBArticulos;
import Gestores.DBTipoArticulos;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sumit
 */
public class CargarArticulo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CargarArticulo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargarArticulo at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
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
        //processRequest(request, response);
        DBTipoArticulos gestorTipoArticulos = new DBTipoArticulos();
        DBArticulos gestorArticulos = new DBArticulos();
        String modo = request.getParameter("modo");

        if (modo == null || modo.isEmpty()) {
            //request.setAttribute("tipoArticulos", gestorTipoArticulos.ObtenerTipoArticulos());

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else if (modo.equals("alta")) {
            ArrayList<TipoArticulo> listaTipoArticulos = gestorTipoArticulos.ObtenerTipoArticulos();
            request.setAttribute("tipoArticulos", listaTipoArticulos);
            RequestDispatcher rd = request.getRequestDispatcher("/AdmCargarArticulo.jsp");
            rd.forward(request, response);
        } else if (modo.equals("actualizar")) {
            int idArticulo = Integer.parseInt(request.getParameter("id"));

            Articulo articulo = gestorArticulos.ObtenerArticuloPorId(idArticulo);

            request.setAttribute("chkPromocion", articulo.isPromocion());
            request.setAttribute("modeloArticulo", articulo);
            ArrayList<TipoArticulo> listaTipoArticulos = gestorTipoArticulos.ObtenerTipoArticulos();
            request.setAttribute("tipoArticulos", listaTipoArticulos);
            RequestDispatcher rd = request.getRequestDispatcher("/AdmCargarArticulo.jsp");
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

        int idTipoArticulo = Integer.parseInt(request.getParameter("cmbTipoArticulo"));
        String articulo = request.getParameter("txtArticulo");
        double precio = Double.parseDouble(request.getParameter("txtPrecio"));
        String linkImagen = request.getParameter("txtImagen");
        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
        String descripcion = request.getParameter("txtDescripcion");
        String promocion = request.getParameter("chkPromocion");
        String idArticulo = request.getParameter("txtIdArticulo");
        Articulo a;
        if (idArticulo == null || idArticulo.isEmpty()) {
            if (cantidad > 0) {
                if (promocion != null) {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, true, linkImagen, descripcion, true);
                } else {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, true, linkImagen, descripcion, false);
                }
                DBArticulos gestorArticulos = new DBArticulos();
                gestorArticulos.AgregarArticulo(a);
            } else {
                if (promocion != null) {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, false, linkImagen, descripcion, true);
                } else {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, false, linkImagen, descripcion, false);
                }
                DBArticulos gestorArticulos = new DBArticulos();
                gestorArticulos.AgregarArticulo(a);
            }
        } else {
            if (cantidad > 0) {
                if (promocion != null) {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, true, linkImagen, descripcion, true);
                } else {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, true, linkImagen, descripcion, false);;
                }
                a.setIdArticulo(Integer.parseInt(idArticulo));
                DBArticulos gestorArticulos = new DBArticulos();
                gestorArticulos.ActualizarArticulo(a);
            } else {
                if (promocion != null) {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, false, linkImagen, descripcion, true);
                } else {
                    a = new Articulo(articulo, precio, cantidad, idTipoArticulo, false, linkImagen, descripcion, false);
                }
                
                a.setIdArticulo(Integer.parseInt(idArticulo));
                DBArticulos gestorArticulos = new DBArticulos();
                gestorArticulos.ActualizarArticulo(a);
            }
        }

        response.sendRedirect(getServletContext().getContextPath() + "/Articulos");

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
