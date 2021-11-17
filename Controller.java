package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

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
        int accion = Integer.parseInt(request.getParameter("pagina"));
        if(accion == 1) {
            //request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
            //response.sendRedirect("homeAdmin.jsp");
            if(request.getAttribute("tipo_usu") == "1") {
                HttpSession s1 = request.getSession();
                s1.setAttribute("admin", request.getAttribute("users"));
                //s1.setAttribute("privad", 1);
                response.sendRedirect("homeAdmin.jsp"); 
            }
        } else if(accion == 2) {
            HttpSession s2 = request.getSession();
            //request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
            s2.setAttribute("usu", request.getAttribute("users"));
            response.sendRedirect("homeUser.jsp");
        } else if (accion == 3) {
            response.sendRedirect("index.jsp");
            
        } else if (accion == 4) {
            HttpSession s3 = request.getSession();
            s3.setAttribute("datos", request.getAttribute("users"));
            response.sendRedirect("datosRecuperados.jsp"); 
        }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
