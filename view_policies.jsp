<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.insurance.dao.model.Policy" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Policies</title>
    <style>table, th, td { border: 1px solid black; border-collapse: collapse; padding: 8px; }</style>
</head>
<body>
    <h2>All Insurance Policies</h2>
    <table>
        <tr>
            <th>ID</th><th>Holder Name</th><th>Type</th><th>Premium</th><th>Expiry Date</th><th>Actions</th>
        </tr>
        <% 
            List<Policy> policies = (List<Policy>) request.getAttribute("policyList");
            if(policies != null) {
                for(Policy p : policies) {
        %>
        <tr>
            <td><%= p.getPolicyId() %></td>
            <td><%= p.getHolderName() %></td>
            <td><%= p.getPolicyType() %></td>
            <td>$<%= p.getPremium() %></td>
            <td><%= p.getExpiryDate() %></td>
            <td>
                <a href="DeletePolicy?id=${policy.policyid}" onclick="return confirm('Are you sure?')">Delete</a>
            </td>
        </tr>
        <% 
                } 
            } else {
        %>
            <tr><td colspan="6">No policies found.</td></tr>
        <% } %>
    </table>
    <br><a href="index.jsp">Back to Home</a>
</body>
</html>