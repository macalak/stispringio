<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="<c:url value="/styles/librarymaster.css"/>"
    type="text/css" />
<title>All Books</title>
</head>

<body>
    <div id="main_wrapper">
        <div id="menu">
            <ul>
                <%--The pageContext is an implicit object available in JSP --%>
                <li><a href="<c:url value="/library/books"/>">View All Books</a></li>
            </ul>
        </div>
        <p></p>
        <h3>Book Detail:</h3>
        <div style="padding-top: 0px;">
            <table style="width: 550px;">
                <tbody>
                    <tr>
                        <td>Title:</td>
                        <td><c:out value="${book.title}"></c:out></td>
                    </tr>
                    <tr>
                        <td>Author:</td>
                        <td><c:out value="${book.author}"></c:out></td>
                    </tr>
                    <tr>
                        <td>Publisher:</td>
                        <td><c:out value="${book.publisher}"></c:out></td>
                    </tr>
                    <tr>
                        <td>Genre:</td>
                        <td><c:out value="${book.genre}"></c:out></td>
                    </tr>
                    <tr>
                        <td>ISBN:</td>
                        <td><c:out value="${book.isbn}"></c:out></td>
                    </tr>
                    <tr>
                        <td>Cat ID:</td>
                        <td><c:out value="${book.catId}"></c:out></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>