<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:if test="${result ne null}">
	<div class="errorresult">${result}</div>
</c:if>

<div style="padding-top: 20px;">
	<h3>Add Book:</h3>

	<form:form  modelAttribute="book" method="post">
		<table style="width: 550px; margin-left: auto; margin-right: auto;">
			<tbody>
				<tr>
					<td><label for="titleInput">Title:</label></td>
					<td><form:input path="title" id="titleInput"/></td>
					<td><form:errors path="title" cssClass="errorresult"></form:errors></td>
				<tr>
					<td><label for="authorInput">Author:</label></td>
					<td><form:input path="author" id="authorInput" /></td>
					<td><form:errors path="author" cssClass="errorresult"></form:errors></td>
				</tr>
				<tr>
					<td><label for="publisherInput">Publisher:</label></td>
					<td><form:input path="publisher" id="publisherInput"/></td>
					<td><form:errors path="publisher" cssClass="errorresult"></form:errors></td>
				</tr>
				<tr>
				    <td><label for="genreSelect">Genre:</label></td>
				 	<td>
				 		<form:select path="genre" id="genreSelect">
        					<form:option value="">Select Book genre: </form:option>
        					<c:forEach items="${genres}" var="genre">
          						<form:option value="${genre}">${genre}</form:option>
        					</c:forEach>
      					</form:select>
					</td>
					<td><form:errors path="genre" cssClass="errorresult"></form:errors></td>
				</tr>
				<tr>
					<td><label for="isbnInput">ISBN:</label></td>
					<td><form:input path="isbn" id="isbnInput"/></td>
					<td><form:errors path="isbn" cssClass="errorresult"></form:errors></td>
				</tr>
				<tr>
					<td><label for="catidInput">Cat ID:</label></td>
					<td><form:input path="catId" id="catidInput"/></td>
					<td><form:errors path="catId" cssClass="errorresult"></form:errors></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Add" /></td>
				</tr>
			</tbody>
		</table>
	</form:form>
</div>
