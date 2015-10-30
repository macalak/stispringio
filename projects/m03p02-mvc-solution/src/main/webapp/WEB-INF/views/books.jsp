<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <div style="padding-top: 20px;">
     <c:if test="${result ne null}">
         <div class="errorresult">${result}</div>
     </c:if>
     <ul>
       <c:forEach items="${books}" var="book">
           <li><a href="book/${book.id}">${book.title}(${book.author})</a></li>
       </c:forEach>
     </ul>
</div>
