<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> T
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <style type="text/css">
        body {
            background: lavender;
        }
    </style>
    <meta charset="ISO-8859-1">
    <title>Complaint Details</title>
</head>
<body>
    <center>
        <h2>Show Complaint Details</h2>
        <c:choose>
        <c:when test="${not empty complaint}">
            <table border="1" >
                <tr>
                <th>Complaint Id</th><th>Customer Name</th><th>Complaint Type</th><th>Description</th><th>Date of Incidence</th><th>Loss of Amount</th>
                </tr>
                <c:forEach var="complaint" items="${complaints}">
                    <tr>
                    <td align="right">${compliant.compliantId+10000}</td>
                    <td align="center">${compliant.customerName}</td>
                    <td align="center">${compliant.compliantTypeId}</td>
                    <td align="center">${compliant.description}</td>
                    <td align="center"><fmt:formatDate pattern="dd-MMM-yyyy" value="${complaint.dateOfIncidence}" /></td>
                    <td align="right">${compliant.amount}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <h3 style="color: blue">No records Found...</h3>
        </c:otherwise>
        </c:choose>

        <br><br><a href="${pageContext.request.contextPath}/index.jsp">HOME</a>
    </center>
</body>
</html>