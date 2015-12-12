<%--
  Created by IntelliJ IDEA.
  User: nni
  Date: 12/11/2015
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Invoice</title>
</head>
<body>
    <h4>This page is for invoice</h4>

    ${requestScope.header}

    <br><br>
    ${requestScope.lines}
</body>
</html>
