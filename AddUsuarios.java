package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import model.SucursalDao;
import model.Usuarios;
import model.UsuariosDao;

public class AddUsuarios extends HttpServlet {
    private Usuarios usu;
    private UsuariosDao dao;
    private SucursalDao sucdao;
    private int idUser;
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
            usu = new Usuarios();
            dao = new UsuariosDao();
            sucdao = new SucursalDao();
       
            String accion = request.getParameter("crud");
            try {
                List sucs = sucdao.listaSucursales();
                request.setAttribute("sucursales", sucs);
                switch(accion) {
                    case "listar":
                        List lista = dao.listar();
                        request.setAttribute("usuarios", lista);
                        request.getRequestDispatcher("homeAdmin.jsp?menu=8").forward(request, response);
                    break;
                    
                    case "add":
                        String username = request.getParameter("user");
                        String pwd = request.getParameter("pass");
                        int tipo = Integer.parseInt(request.getParameter("usut"));
                        int sucursal = Integer.parseInt(request.getParameter("idDep"));
                        usu.setNombre_usuario(username);
                        usu.setPassword(pwd);
                        usu.setTipo_usuario(tipo);
                        usu.setIdDependencia(sucursal);
                        dao.add(usu);
                        request.getRequestDispatcher("AddUsuarios?crud=listar").forward(request, response);
                    break;
                    
                    case "edit":
                        idUser = Integer.parseInt(request.getParameter("id"));
                        Usuarios us = dao.listarId(idUser);
                        request.setAttribute("usuario", us);
                        request.getRequestDispatcher("AddUsuarios?crud=listar").forward(request, response);
                        //response.sendRedirect("AddUsuarios?crud=listar");
                    break;
                    
                    case "update":
                        int estado = 1;
                        String uname = request.getParameter("user");
                        String passw = request.getParameter("pass");
                        int tipous = Integer.parseInt(request.getParameter("usut"));
                        int dep = Integer.parseInt(request.getParameter("idDep"));
                        usu.setNombre_usuario(uname);
                        usu.setPassword(passw);
                        usu.setTipo_usuario(tipous);
                        usu.setIdDependencia(dep);
                        usu.setEstado(estado);
                        usu.setIdUsu(idUser);
                        dao.update(usu);
                        request.getRequestDispatcher("AddUsuarios?crud=listar").forward(request, response);
                    break;
                    
                    case "delete":
                        idUser = Integer.parseInt(request.getParameter("id"));
                        dao.delete(idUser);
                        request.getRequestDispatcher("AddUsuarios?crud=listar").forward(request, response);
                    break;
                    
                    case "check":
                        if(dao.checkUser(request.getParameter("user"))) {
                            request.setAttribute("check", "si");
                        } else {
                            request.setAttribute("check", "no");
////                            JOptionPane.showMessageDialog(null, "El número del expediente tiene que ser de 13 digítos", "Error de captura",JOptionPane.ERROR_MESSAGE);
                        }
//                        request.getRequestDispatcher("AddUsuarios?crud=listar").forward(request, response);
                    break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(AddUsuarios.class.getName()).log(Level.SEVERE, null, ex);
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
