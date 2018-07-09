<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 14.05.2018
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<sf:form modelAttribute="spitter" action="/spitter/register" method="post">
    <div>
        <sf:errors path="username" cssClass="error"/>
        <label for="register_username">Username</label>
        <sf:input id="register_username" size="15" maxlength="15" path="username"></sf:input>
    </div>
    <div>
        <sf:errors path="email" cssClass="error"/>
        <label for="register_email">Email</label>
        <sf:input id="register_email" size="15" path="email"></sf:input>
    </div>
    <div>
        <sf:errors path="password" cssClass="error"/>
        <label for="register_password">Password</label>
        <sf:password id="register_password" size="15" maxlength="15" path="password"></sf:password>
    </div>
    <sf:button>Register</sf:button>
    <%--<button></button>--%>
</sf:form>