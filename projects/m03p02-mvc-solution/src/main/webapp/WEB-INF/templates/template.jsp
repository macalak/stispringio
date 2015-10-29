<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<c:set var="titleKey">        
        <tiles:getAsString name="title" />
 	</c:set>
	<link rel="stylesheet" type="text/css" href="<c:url value="/styles/librarymaster.css"/>" >
	<title>${titleKey}</title>
</head>


<body>
    <div id="main_wrapper">
       <tiles:insertAttribute name="header"/>
       <div>
	       <tiles:insertAttribute name="body" />
    	   <div class="clear"></div>
       </div>
       <tiles:insertAttribute name="footer" />       
    </div>
</body>
</html>

