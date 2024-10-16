package example.servlet.book;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Boolean adminLoggedIn = (Boolean) request.getSession().getAttribute("adminLoggedIn");
        if (adminLoggedIn != null && adminLoggedIn) {
            // Admin is logged in, proceed with admin actions
            response.getWriter().println("Admin actions go here");
        } else {
            // Admin is not logged in, redirect to login page
            response.sendRedirect(request.getContextPath() + "/login.html");
        }
    }
}
