<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <style type="text/css">
            body {
                background: lavender;
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Index Page</title>
    </head>
    <body>
        <center>
            <h2>Welcome to Customer Complaint Services</h2>
            <a href="${pageContext.request.contextPath}/loadComplaintForm.html">File a Complaint</a>
            <br><br>
            <a href="${pageContext.request.contextPath}/loadComplaintReport.html">Display Complaint Report</a>
        </center>
    </body>
</html>