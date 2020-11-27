/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longtr.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import longtr.user.UserDAO;
import longtr.user.UserDTO;
import longtr.user.UserErrorDTO;
import org.apache.log4j.Logger;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    private final Logger LOGGER = Logger.getLogger(LoginServlet.class);
    private final String ERROR_PAGE = "login.jsp";
    private final String STORE_PAGE = "store";
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
        PrintWriter out = response.getWriter();
        
        String userID = request.getParameter("txtUserID");
        String password = request.getParameter("txtPassword");
        
        String url = ERROR_PAGE;
        
        UserDAO uDao = new UserDAO();
        UserErrorDTO errDto = new UserErrorDTO();
        
        try {
            /* TODO output your page here. You may use following sample code. */
            boolean error = false;
            if(userID.length() == 0){
                error = true;
                errDto.setErrID("What is your username?");
            }
            
            UserDTO uDto = uDao.checkLogin(userID, password);
            if(uDto != null){
                HttpSession session = request.getSession();
                session.setAttribute("USER", uDto);
                
                Cookie cookie = new Cookie(userID, password);
                response.addCookie(cookie);
                
            }else{
                error = true;
                errDto.setErrPassword("Username and password are invalid");
            }
            
            if(error = false){
                url = STORE_PAGE;
            }
            
            request.setAttribute("ERR", errDto);
        }catch(NamingException e){
            LOGGER.error("LoginServlet_Naming: " + e.getMessage());
        }catch(SQLException e){
            LOGGER.error("LoginServlet_SQL: " + e.getMessage());
        }finally{
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
