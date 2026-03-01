package com.insurance.servlet;

import com.insurance.dao.PolicyDAO;
import com.insurance.dao.PolicyDAOImpl;
import com.insurance.dao.model.Policy;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AddPolicy")
public class AddPolicyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("holderName");
        String type = request.getParameter("policyType");
        double premium = Double.parseDouble(request.getParameter("premium"));
        Date expiryDate = Date.valueOf(request.getParameter("expiryDate"));

        Policy policy = new Policy(0, name, type, premium, expiryDate);
        PolicyDAO dao = new PolicyDAOImpl();
        dao.addPolicy(policy);
        
        response.sendRedirect("ViewPolicies");
    }
}