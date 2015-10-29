<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<div class="header">
</div>
<div id="menu">
   <div class="left_menu">
	    <ul>
          	<li><a href="<c:url value="/library/books"/>">Books</a></li>
          	<li><a href="<c:url value="/library/book"/>">Add New Book</a></li>
    	</ul>
    </div>

   <div class="right_menu">
	    <ul>
        	<li><a href="<c:url value="/library/logout"/>">logout</a></li>
    	</ul>
    </div>
    
</div>
<div class="clear"></div>
