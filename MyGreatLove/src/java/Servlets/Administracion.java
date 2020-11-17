/*
 * "MyGreatLove"
 * Servlet Administración.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import Gestores.DBConyugue;
import Gestores.DBCuentas;
import Gestores.DBOperaciones;
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

/**
 *
 * @author facut
 */
public class Administracion extends HttpServlet {

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
        String admin = (String) request.getSession().getAttribute("ModoAdmin");

        if (admin != null && !admin.isEmpty()) {
            String modo = request.getParameter("funcion");
            DBCuentas gestorCuentas = new DBCuentas();
            DBParejas gestorParejas = new DBParejas();
            DBConyugue gestorConyugues = new DBConyugue();
            DBOperaciones gestorOperaciones = new DBOperaciones();
            if (modo == null || modo.isEmpty()) {
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            } else if (modo.equals("listadoCuentas")) {
                request.setAttribute("CuentasAdm", gestorCuentas.ObtenerCuentasADM());
                request.setAttribute("MontoTotalDepositos", gestorParejas.ObtenerFondosDeLosMontos());
                request.setAttribute("MontoTotalOperaciones", gestorOperaciones.ObtenerFondosDeLosMontos());
                RequestDispatcher rd = request.getRequestDispatcher("AdmParejas.jsp");
                rd.forward(request, response);
            } else if (modo.equals("update")) {
                String usuario = request.getParameter("user");
                if (usuario != null || usuario.isEmpty()) {
                    Pareja p = gestorParejas.ObtenerInformacionPareja(usuario);
                    ArrayList<Conyugue> Conyugues = gestorConyugues.ObtenerConyuguesDeUnaPareja(p.getIdPareja());
                    Cuenta c = gestorCuentas.ObtenerCuentaPorUsuario(usuario);
                    request.setAttribute("modeloPareja", p);
                    request.setAttribute("Conyugues1", Conyugues.get(0));
                    request.getSession().setAttribute("DniConyugue2", Conyugues.get(0).getDni());
                    request.setAttribute("Conyugues2", Conyugues.get(1));
                    request.setAttribute("Cuenta", c);

                    RequestDispatcher rd = request.getRequestDispatcher("/AdmParejasActualizar.jsp");
                    rd.forward(request, response);
                } else {
                    RequestDispatcher rd = request.getRequestDispatcher("/Portal");
                    rd.forward(request, response);
                }
            } else if (modo.equals("estado")) {
                String id = request.getParameter("id");
                String estado = request.getParameter("Activado");
                if (estado.equals("true")) {
                    gestorCuentas.ActualizarEstado(Integer.parseInt(id), true);
                } else {
                    gestorCuentas.ActualizarEstado(Integer.parseInt(id), false);
                }
                response.sendRedirect(getServletContext().getContextPath() + "/Administracion?funcion=listadoCuentas");
            } else if (modo.equals("listadoOperaciones")) {
                request.setAttribute("AdmOperaciones", gestorOperaciones.ObtenerOperaciones());
                request.setAttribute("AdmOperacionesMontoTotal", gestorOperaciones.ObtenerFondosDeLosMontos());
                RequestDispatcher rd = request.getRequestDispatcher("AdmOperaciones.jsp");
                rd.forward(request, response);
            } else if (modo.equals("VisualizarOperacion")) {
                String id = request.getParameter("id");
                request.setAttribute("AdmOperacionFecha", gestorOperaciones.ObtenerOperacion(Integer.parseInt(id)).get(0).getFecha());
                request.setAttribute("AdmOperacionIdOp", gestorOperaciones.ObtenerOperacion(Integer.parseInt(id)).get(0).getIdOperacion());
                request.setAttribute("AdmOperacionUsuario", gestorOperaciones.ObtenerOperacion(Integer.parseInt(id)).get(0).getUsuario());
                request.setAttribute("AdmOperacionFacturado", gestorOperaciones.ObtenerOperacion(Integer.parseInt(id)).get(0).getTotalFacturado());
                request.setAttribute("AdmOperacion", gestorOperaciones.ObtenerOperacion(Integer.parseInt(id)));
                RequestDispatcher rd = request.getRequestDispatcher("AdmOperacion.jsp");
                rd.forward(request, response);
            } else if (modo.equals("top5")) {
                request.setAttribute("Top5", gestorOperaciones.ObtenerTop5Ventas());
                RequestDispatcher rd = request.getRequestDispatcher("AdmTop5Ventas.jsp");
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("/Portal");
            }
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("SeccionAdministrador.jsp");
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
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        DBConyugue gestorConyugues = new DBConyugue();
        DBParejas gestorParejas = new DBParejas();
        DBCuentas gestorCuentas = new DBCuentas();

        switch (action) {
            case "updatep":
                int idCuenta = Integer.parseInt(request.getParameter("txtIdCuenta"));
                String Conyugue1Nombre = request.getParameter("txtConyugue1Nombre");
                String Conyugue1Apellido = request.getParameter("txtConyugue1Apellido");
                String Conyugue2Nombre = request.getParameter("txtConyugue2Nombre");
                String Conyugue2Apellido = request.getParameter("txtConyugue2Apellido");
                int dni1 = Integer.parseInt(request.getParameter("txtIdConyugue1"));
                int dni2 = Integer.parseInt(request.getParameter("txtIdConyugue2"));
                String usuario = request.getParameter("txtUsuario");
                String clave = request.getParameter("txtClave");
                Cuenta cuentaPareja = gestorCuentas.ObtenerCuenta(idCuenta);
                Pareja p = gestorParejas.ObtenerInformacionPareja(cuentaPareja.getUsuario());
                Conyugue c1 = new Conyugue();
                c1.setApellido(Conyugue1Apellido);
                c1.setNombre(Conyugue1Nombre);
                c1.setDni(dni1);
                gestorConyugues.ActualizarConyugues(c1);
                Conyugue c2 = new Conyugue();
                c2.setApellido(Conyugue2Apellido);
                c2.setNombre(Conyugue2Nombre);
                c2.setDni(dni2);
                gestorConyugues.ActualizarConyugues(c2);
                Cuenta c = new Cuenta();
                c.setUsuario(usuario);
                c.setPassword(clave);
                c.setIdCuenta(p.getIdCuenta());
                gestorCuentas.ActualizarCuenta(c);
                response.sendRedirect(getServletContext().getContextPath() + "/Administracion?funcion=update&user=" + usuario);
                break;
            default:
                response.sendRedirect(getServletContext().getContextPath() + "/Administracion?funcion=listadoCuentas");
                break;
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
