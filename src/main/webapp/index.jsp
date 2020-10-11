<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
    <head>
        <title>JSP Title</title>
    </head>
    <body>

        <h2>Static page "index.jsp"!</h2>
        <a href="servlet">Click here to see servlet</a>

    </body>
</html>
<c:redirect url="servlet"/>
