<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.insurance.dao.model.Policy" %>
<!DOCTYPE html>
<html>
<head>
<title>Update Policy</title>
<style>
    body { font-family: Arial; margin: 50px; }
    form { width: 300px; padding: 20px; border: 1px solid #ccc; border-radius: 8px; }
    input { width: 100%; margin-bottom: 15px; padding: 8px; }
    label { font-weight: bold; }
    .btn { background: #4CAF50; color: white; border: none; cursor: pointer; }
</style>
</head>
<body>

    <h2>Edit Policy Details</h2>

    <%
        // 1. Retrieve the policy object passed from the Servlet's doGet method
        Policy policy = (Policy) request.getAttribute("policy");
        
        if (policy != null) {
    %>
        <!-- 2. Form action must match your @WebServlet("/updatePolicy") mapping -->
        <form action="updatePolicy" method="POST">
            
            <!-- Hidden field for ID to tell the DB which record to update -->
            <input type="hidden" name="policyid" value="<%= policy.getPolicyId() %>">

            <label>Holder Name:</label>
            <input type="text" name="holdername" value="<%= policy.getHolderName() %>" required>

            <label>Policy Type:</label>
            <input type="text" name="policytype" value="<%= policy.getPolicyType() %>" required>

            <label>Premium Amount:</label>
            <input type="number" step="0.01" name="premium" value="<%= policy.getPremium() %>" required>

            <label>Expiry Date (YYYY-MM-DD):</label>
            <input type="date" name="expirydate" value="<%= policy.getExpiryDate() %>" required>

            <input type="submit" value="Save Changes" class="btn">
            <a href="viewPolicy">Cancel</a>
        </form>
    <% 
        } else { 
    %>
        <p style="color:red;">Error: No policy data found to edit.</p>
        <a href="viewPolicy">Go back to list</a>
    <% } %>

</body>
</html>
