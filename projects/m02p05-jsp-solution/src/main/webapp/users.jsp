<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="usersController" class="ite.librarymaster.web.controller.UsersController" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Library Master</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>

    <h1>Users</h1>

    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
            <th>State</th>
        </tr>

            <c:forEach items="${usersController.users}" var="object">
            <tr>
                <td>${object.id}</td>
                <td>${object.name}</td>
                <td>${object.surname}</td>
                <td>${object.userState.name()}</td>
            </tr>
            </c:forEach>
    </table>

</body>
</html>
