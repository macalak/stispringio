<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="ite.librarymaster.model.Book" %>
<%@ page import="ite.librarymaster.service.LibraryService" %>
<%@ page import="java.util.*" %>
<%@ page import="ite.librarymaster.ServiceLocator" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Films</title>
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

        <%  LibraryService libraryService = ServiceLocator.getInstance().getLibraryService();
            List<Book> books = libraryService.getAllBooks();

            for (Book book : books) { %>
            <tr>
                <td><%= book.getIsbn() %></td>
                <td><%= book.getTitle() %></td>
                <td><%= book.getAuthor() %></td>
                <td><%= book.getGenre().name() %></td>
            </tr>
        <% } %>
    </table>
    </body>
</html>
