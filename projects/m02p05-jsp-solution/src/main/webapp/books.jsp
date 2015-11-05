<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<jsp:useBean id="booksController" class="ite.librarymaster.web.controller.BooksController" />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Books</title>
    <meta http-equiv="Content-Type"
          content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css"
          href="css/style.css"/>
</head>
<body>
    <h1>List of Books</h1>

    <table>
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Author</th>
            <th>Genre</th>
        </tr>

        <c:forEach items="${booksController.books}" var="object">
            <tr>
                <td>${object.isbn}</td>
                <td>${object.title}</td>
                <td>${object.author}</td>
                <td>${object.genre.name()}</td>
            </tr>
        </c:forEach>
    </table>
    </body>
</html>
