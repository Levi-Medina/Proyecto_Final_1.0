package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuarios;
import model.UsuariosDao;

public class Login extends HttpServlet {
    private UsuariosDao dao;
    private Usuarios usu;

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
        HttpSession sesion = request.getSession();
        String user, pass;
        dao = new UsuariosDao();
        usu = new Usuarios();
        String accion = request.getParameter("action");
        if (accion.equalsIgnoreCase("Entrar")) {
            user = request.getParameter("user");
            pass = request.getParameter("pwd");
            try {
                usu = dao.login(user, pass);
                if(usu.getTipo_usuario() == 1) {
                    request.setAttribute("users", usu);
                    request.setAttribute("tipo_usu", "1");
                    request.getRequestDispatcher("Controller?pagina=1").forward(request, response);
                } else if(usu.getTipo_usuario() == 2) {
                    request.setAttribute("users", usu);
                    request.setAttribute("tipo_usu", "2");
                    request.getRequestDispatcher("Controller?pagina=2").forward(request, response);
                } else {
                    request.setAttribute("tipo_usu", "0");
                    request.getRequestDispatcher("index.jsp?error=1").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  else if (accion.equalsIgnoreCase("Recuperar")) {
            String us = request.getParameter("nameuser");
            try {
                usu = dao.recoverPassword(us);
                if(usu.getTipo_usuario() == 1) {
                    request.setAttribute("users", usu);
                    request.setAttribute("tipo", "administrador");
                    request.getRequestDispatcher("Controller?pagina=4").forward(request, response);
                } else if(usu.getTipo_usuario() == 2) {
                    request.setAttribute("users", usu);
                    request.setAttribute("tipo", "usuario");
                    request.getRequestDispatcher("Controller?pagina=4").forward(request, response);
                } else {
                    request.setAttribute("tipo_usu", "0");
                    request.getRequestDispatcher("recuperarPassword.jsp?error=1").forward(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
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
