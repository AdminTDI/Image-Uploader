<%-- 
    Document   : message
    Created on : May 16, 2019, 4:31:00 PM
    Author     : fhfai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
            alert("<%= request.getAttribute("message")%>");
        </script>
    </head>
    <body>
    <center>
        <h1 style="width: 500px; padding: 30px; background-color: dimgrey; color: white">Profile Details</h1>
        <img width="210" height="150" src="data:image/jpeg;base64,<%= request.getAttribute("img")%>"/>
        <p>Name: ${param.fn} ${param.ln}</p>
    </center>
</body>
</html>
