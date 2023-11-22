
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>CHào mừng<%=((User)session.getAttribute("user_login")).getFullName()%>Back</h1>
</body>
</html>
