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
        <div>
            <ul>
                <c:forEach items="${books}" var="book">
                    <li><a href="book/${book.id}">${book.title}
                            (${book.author})</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</body>

</html>