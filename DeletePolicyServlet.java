package com.insurance.servlet;

import com.insurance.dao.PolicyDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DeletePolicy")
public class DeletePolicyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        new PolicyDAOImpl().deletePolicy(id);
        response.sendRedirect("ViewPolicies");
    }
}