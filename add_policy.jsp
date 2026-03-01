<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Add Policy</title></head>
<body>
    <h2>Add New Insurance Policy</h2>
    <form action="../AddPolicy" method="post">
        Holder Name: <input type="text" name="holderName" required><br><br>
        Policy Type: 
        <select name="policyType">
            <option value="Life">Life</option>
            <option value="Health">Health</option>
            <option value="Vehicle">Vehicle</option>
        </select><br><br>
        Premium: <input type="number" step="0.01" name="premium" required><br><br>
        Expiry Date: <input type="date" name="expiryDate" required><br><br>
        <input type="submit" value="Add Policy">
    </form>
    <br><a href="../index.jsp">Back to Home</a>
</body>
</html>