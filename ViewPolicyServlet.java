package com.insurance.servlet;

import com.insurance.dao.PolicyDAOImpl;
import com.insurance.dao.model.Policy;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ViewPolicies")
public class ViewPolicyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Policy> list = new PolicyDAOImpl().getAllPolicies();
        request.setAttribute("policyList", list);
        request.getRequestDispatcher("view/view_policies.jsp").forward(request, response);
    }
}