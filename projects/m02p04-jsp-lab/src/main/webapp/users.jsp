<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="ite.librarymaster.model.User" %>
<%@page import="ite.librarymaster.service.UserService" %>
<%@page import="ite.librarymaster.ServiceLocator"%>
<%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

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

        <%
            UserService userService =
                    ServiceLocator.getInstance().getUserService();
            List<User> users = userService.getAllUsers();
            for (User user : users) { %>
            <tr>
                <td><%= user.getId() %></td>
                <td><%= user.getName() %></td>
                <td><%= user.getSurname() %></td>
                <td><%= user.getUserState().name() %></td>
            </tr>
        <% } %>
    </table>

</body>
</html>
