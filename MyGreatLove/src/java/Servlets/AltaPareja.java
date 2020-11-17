/*
 * "MyGreatLove"
 * Servlet AltaPareja.
 * Alumno: Facundo Roldan. Legajo:109505. Comisión:2W50. Tema: Nº2
 */
package Servlets;


import Modelos.Conyugue;
import java.io.IOException;
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
public class AltaPareja extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("/altapareja.jsp");
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
        
        String nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        int dni = Integer.parseInt(request.getParameter("txtDNI"));
        String nombre2 = request.getParameter("txtNombre2");
        String apellido2 = request.getParameter("txtApellido2");
        int dni2 = Integer.parseInt(request.getParameter("txtDNI2"));
        
        
        //DBConyugue gestorConyugue = new DBConyugue();
        Conyugue c1 = new Conyugue();
        Conyugue c2 = new Conyugue();

        c1.setDni(dni);
        c1.setNombre(nombre);
        c1.setApellido(apellido);
        c1.setEstado(true);
        
        //gestorConyugue.AgregarConyugue(c2);
     
        c2.setDni(dni2);
        c2.setNombre(nombre2);
        c2.setApellido(apellido2);
        c2.setEstado(true);
        
        //gestorConyugue.AgregarConyugue(c2);
        
        //request.getSession().setAttribute("dni_01", dni);
        //request.getSession().setAttribute("dni_02", dni);
        HttpSession misession= request.getSession(true);
        misession.setAttribute("Conyugue1", c1);
        misession.setAttribute("Conyugue2", c2);
        
        
        request.getSession().setAttribute("altaConyugue", "validar");
        
        response.sendRedirect(getServletContext().getContextPath()+ "/CrearCuenta");
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
