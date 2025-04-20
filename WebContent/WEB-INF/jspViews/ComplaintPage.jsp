<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <style type="text/css">
        body {
            background: Lavender;
        }
    </style>

    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Complaint Page</title>
    <style>
        .error {
            color: #ff0000;
            font-style: italic;
        }
    </style>
</head>
<body>
    <center>
        <h2><u>File Complaint</u></h2>
        <form:form action="processComplaintForm.html" method="POST" modelAttribute="complaintBean">
        <table>
        <tr>
        <td>Customer Name</td>
        <td><form:input path="customerName"/></td>
        <td><form:errors cssClass="error" path="customerName" /></td>
        </tr>

        <tr>
        <td>Customer Type</td>
        <td><form:select path="complaintTypeId">
        <form:option label="--Select--" value=""/>
        <form:options items="${types}" />
        </form:select></td>
        <td><form:errors cssClass="error" path="complaintTypeId" /></td>
        </tr>
        <tr>
        <td>Description</td>
        <td><form:input path="description"/></td>
        </tr>
        <tr>
        <td>Date of Incidence<br>[dd-MMM-yyyy]</td>
        <td><form:input path="dateOfIncidence"/></td>
        <td><form:errors cssClass="error" path="dateOfIncidence" /></td>
        </tr>
        <tr>
        <td>Total loss of amount<br>from this incident</td>
        <td><form:input path="amount"/></td>
        <td><form:errors cssClass="error" path="amount" >/td>
        </tr>
        </table>
        <br>
        <input type="submit" value="Submit Complaint" >
        </form:form>
        <br><a href="${pageContext.request.contextPath}/index.jsp">HOME</a>
    </center>
</body>
</html>