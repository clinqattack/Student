package org.example.jdbclearning.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "Update", urlPatterns = "/update")
public class Update extends HttpServlet {
    @Autowired
    private Connection con;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =  Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String branch = request.getParameter("branch");
        try {
            PreparedStatement pstmt = con.prepareStatement(
                    """
                        UPDATE students SET student_name =  ?, student_age = ?, student_branch = ? WHERE student_id = ?;
                        """
            );
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, branch);
            pstmt.setInt(4, id);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        response.sendRedirect("index.html");
    }
}
