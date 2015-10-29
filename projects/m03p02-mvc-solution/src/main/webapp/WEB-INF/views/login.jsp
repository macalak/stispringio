<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${exception ne null}">
    <div class="errorresult">
        <span style="font-size: 16px"> ${exception.message} </span>
    </div>
</c:if>
<form action="<c:url value="/library/login"/>" method="post">
    <fieldset style="width: 550px;margin-left:auto;margin-right:auto;">
        <legend>Login</legend>
        <table>
        <tr>
            <td>Username</td>
            <td><input type="text" id="username" name="username" placeholder="usename"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" id="password" name="password" placeholder="password"/></td>
        </tr>
        <tr><td colspan="2" align="center"><button id="login">Login</button></td></tr>
        </table>
    </fieldset>
</form>
