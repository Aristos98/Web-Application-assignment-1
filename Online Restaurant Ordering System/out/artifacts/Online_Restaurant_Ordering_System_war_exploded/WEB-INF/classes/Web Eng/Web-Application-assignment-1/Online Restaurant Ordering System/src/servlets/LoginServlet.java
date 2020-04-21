package servlets;

import com.sun.net.httpserver.HttpsServer;
import oracle.net.ns.SessionAtts;
import utilities.DbUtility;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();

        response.setContentType("text/html");
        if(DbUtility.checkUserExist(username, password)){
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            response.sendRedirect("main-page.jsp");
        }else{
            HttpSession session = request.getSession(true);
            session.setAttribute("attemptUsername", username);
            response.sendRedirect("login-page.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
