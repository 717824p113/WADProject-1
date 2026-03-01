package com.insurance.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.insurance.dao.PolicyDAOImpl;
import com.insurance.dao.model.Policy;
import java.sql.Date;

@WebServlet("/updatePolicy") // Use this URL in your browser and JSP links
public class UpdatePolicyServlet extends HttpServlet {

    // 1. Fetch existing data for the edit form
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Policy policy = new PolicyDAOImpl().getPolicyById(id);
        request.setAttribute("policy", policy);
        request.getRequestDispatcher("update_policy.jsp").forward(request, response);
    }

    // 2. Process the actual update after form submission
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        Policy p = new Policy();
        p.setPolicyId(Integer.parseInt(request.getParameter("policyid")));
        p.setHolderName(request.getParameter("holdername"));
        p.setPolicyType(request.getParameter("policytype"));
        p.setPremium(Double.parseDouble(request.getParameter("premium")));
        p.setExpiryDate(Date.valueOf(request.getParameter("expirydate")));

        new PolicyDAOImpl().updatePolicy(p);
        response.sendRedirect("viewPolicy"); // Redirect back to table
    }
}
