package org.example.jdbclearning.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Add", urlPatterns = "/add")
public class Add extends HttpServlet {
    @Autowired
    private Connection con;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name =  request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String branch = request.getParameter("branch");
        try {
            PreparedStatement stmt = con.prepareStatement(" INSERT INTO students (student_name, student_age, student_branch) VALUES (?, ?, ?)");
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, branch);
            stmt.executeUpdate();
            stmt.close();
        } catch(SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        response.sendRedirect(response.encodeRedirectURL("index.html"));
    }
}
