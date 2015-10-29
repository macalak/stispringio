<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div style="padding-top: 20px;">
        <h3>Detail of Book: &quot;<c:out value="${book.title}"/>&quot;</h3>
        <div>
            <table style="width: 550px;margin-left:auto;margin-right:auto;">
                <tbody>
                    <tr>
                        <td>Title:</td>
                        <td><c:out value="${book.title}"/></td>
                    </tr>
                    <tr>
                        <td>Author:</td>
                        <td><c:out value="${book.author}"/></td>
                    </tr>
                    <tr>
                        <td>Publisher:</td>
                        <td><c:out value="${book.publisher}"/></td>
                    </tr>
                    <tr>
                        <td>Genre:</td>
                        <td><c:out value="${book.genre}"/></td>
                    </tr>
                    <tr>
                        <td>ISBN:</td>
                        <td><c:out value="${book.isbn}"/></td>
                    </tr>
                    <tr>
                        <td>Cat ID:</td>
                        <td><c:out value="${book.catId}"/></td>
                    </tr>
                </tbody>
            </table>
        </div>
</div>        
