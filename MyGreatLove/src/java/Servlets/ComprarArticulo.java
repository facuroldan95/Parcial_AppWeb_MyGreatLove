/*
 * "MyGreatLove"
 * Servlet ComprarArticulo.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;

import DTOs.DTOArticulo;
import Gestores.DBArticulos;
import Gestores.DBOperaciones;
import Gestores.DBParejas;
import Modelos.Articulo;
import Modelos.Operacion;
import Modelos.Pareja;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ComprarArticulo extends HttpServlet {

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

        if (modo == null || modo.isEmpty()) {
            //request.setAttribute("tipoArticulos", gestorTipoArticulos.ObtenerTipoArticulos());

            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } else if (modo.equals("buy")) {

            int idArticulo = Integer.parseInt(request.getParameter("id"));

            DBArticulos gestor = new DBArticulos();

            DTOArticulo a = gestor.ObtenerDTOArticuloPorId(idArticulo);

            request.setAttribute("modeloArticulo", a);
            RequestDispatcher rd = request.getRequestDispatcher("CompraArticulo.jsp");
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
        String usuario = (String) request.getSession().getAttribute("usr");
        request.setAttribute("mensajeError", "mensajeError");
        ArrayList<Articulo> listado = new ArrayList<>();
        //int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));

        DBParejas gestorParejas = new DBParejas();
        DBOperaciones DBOp = new DBOperaciones();
        DBArticulos gestorArticulos = new DBArticulos();

        switch (action) {
            case "comprar": {
                double monto = Double.parseDouble(request.getParameter("txtMonto"));
                Pareja p = gestorParejas.ObtenerInformacionPareja(usuario);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String fecha = String.valueOf(formatter.format(date));
                double saldo = p.getMonto();
                if (saldo < monto) {
                    listado = new ArrayList<>();
                    request.getSession().setAttribute("Carrito", listado);
                    request.getSession().setAttribute("Fondos", "Insuficiente");
                    RequestDispatcher rd = request.getRequestDispatcher("/FondoInsuficiente.jsp");
                    rd.forward(request, response);
                } else {
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                    int idArticulo = Integer.parseInt(request.getParameter("txtIdArticulo"));
                    Operacion op = new Operacion();
                    op.setIdPareja(p.getIdPareja());
                    op.setFecha(fecha);
                    int nuevoStock = stock - cantidad;
                    if (stock == cantidad) {
                        listado = new ArrayList<>();
                        request.getSession().setAttribute("Carrito", listado);
                        DBOp.AgregarOperacion(op);
                        int idOperacion = DBOp.ObtenerIdOperacion(p.getIdPareja());
                        DBOp.CargarOperaciones(idOperacion, idArticulo, monto, cantidad, cantidad * monto);
                        gestorArticulos.ActualizarCantidad(nuevoStock, idArticulo, false);
                        double saldoRestante = saldo - monto;
                        gestorParejas.ModicicarSaldo(saldoRestante, p.getIdPareja());
                    } else if (stock < cantidad) {
                        listado = new ArrayList<>();
                        request.getSession().setAttribute("Carrito", listado);
                        RequestDispatcher rd = request.getRequestDispatcher("/SinStock.jsp");
                        rd.forward(request, response);
                    } else {
                        DBOp.AgregarOperacion(op);
                        int idOperacion = DBOp.ObtenerIdOperacion(p.getIdPareja());
                        double montoTotal = cantidad * monto;
                        DBOp.CargarOperaciones(idOperacion, idArticulo, monto, cantidad, montoTotal);
                        gestorArticulos.ActualizarCantidad(nuevoStock, idArticulo, true);
                        double saldoRestante = saldo - montoTotal;
                        gestorParejas.ModicicarSaldo(saldoRestante, p.getIdPareja());
                    }

                    response.sendRedirect(getServletContext().getContextPath() + "/Articulos");
                }
                break;
            }
            case "carrito": {

                listado = (ArrayList) request.getSession().getAttribute("Carrito");
                if (listado == null) {
                    listado = new ArrayList<Articulo>();
                }
                int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
                int idArticulo = Integer.parseInt(request.getParameter("txtIdArticulo"));
                Articulo a = gestorArticulos.ObtenerArticuloPorId(idArticulo);
                a.setAuxCant(cantidad);
                listado.add(a);
                request.getSession().setAttribute("Carrito", listado);
                response.sendRedirect(getServletContext().getContextPath() + "/Articulos");
                break;
            }
            case "terminar": {
                double monto = 0;
                boolean carrito = false;
                Pareja p = gestorParejas.ObtenerInformacionPareja(usuario);
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String fecha = String.valueOf(formatter.format(date));
                double saldo = p.getMonto();
                listado = (ArrayList) request.getSession().getAttribute("Carrito");
                //cantidades = (ArrayList) request.getSession().getAttribute("Cantidades");
                for (Articulo articulo : listado) {
                    monto += articulo.getPrecio() * articulo.getAuxCant();
                }
                if (saldo < monto) {
                    listado = new ArrayList<>();
                    request.getSession().setAttribute("Carrito", listado);
                    request.getSession().setAttribute("Fondos", "Insuficiente");
                    RequestDispatcher rd = request.getRequestDispatcher("/FondoInsuficiente.jsp");
                    rd.forward(request, response);
                } else {
                    Operacion op = new Operacion();
                    op.setIdPareja(p.getIdPareja());
                    op.setFecha(fecha);

                    for (Articulo articulo : listado) {
                        if (articulo.getCantidad() == articulo.getAuxCant()) {
                            carrito = true;
                        } else if (articulo.getCantidad() < articulo.getAuxCant()) {
                            carrito = false;
                            break;
                        } else {
                            carrito = true;
                        }
                    }

                    if (carrito) {
                        DBOp.AgregarOperacion(op);
                        int idOperacion = DBOp.ObtenerIdOperacion(p.getIdPareja());
                        for (Articulo articulo : listado) {
                            DBOp.CargarOperaciones(idOperacion, articulo.getIdArticulo(), articulo.getPrecio(), articulo.getAuxCant(), articulo.getPrecio() * articulo.getAuxCant());
                            if (articulo.getCantidad() == articulo.getAuxCant()) {
                                gestorArticulos.ActualizarCantidad(articulo.getCantidad() - articulo.getAuxCant(), articulo.getIdArticulo(), false);
                            } else if (articulo.getCantidad() < articulo.getAuxCant()) {

                            } else {
                                gestorArticulos.ActualizarCantidad(articulo.getCantidad() - articulo.getAuxCant(), articulo.getIdArticulo(), true);
                            }
                        }
                        double saldoRestante = saldo - monto;
                        gestorParejas.ModicicarSaldo(saldoRestante, p.getIdPareja());
                    } else {
                        listado = new ArrayList<>();
                        request.getSession().setAttribute("Carrito", listado);
                        RequestDispatcher rd = request.getRequestDispatcher("/SinStock.jsp");
                        rd.forward(request, response);
                    }

                    listado = new ArrayList<>();
                    request.getSession().setAttribute("Carrito", listado);
                    response.sendRedirect(getServletContext().getContextPath() + "/Articulos");
                }
                break;
            }
            default:
                response.sendRedirect(getServletContext().getContextPath() + "/Articulos");
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
