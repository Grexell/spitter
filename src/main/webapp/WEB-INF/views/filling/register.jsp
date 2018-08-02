<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 14.05.2018
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="left left-1-3 material-box">
    <h1 class="h-text">Register</h1>
    <sf:form modelAttribute="spitter" action="/spitter/register" method="post">
        <div class="input-field">
            <sf:errors path="username" cssClass="error"/>
            <label for="register_username">Username</label>
            <sf:input id="register_username" size="15" maxlength="15" path="username" placeholder="username"></sf:input>
        </div>
        <div class="input-field">
            <sf:errors path="email" cssClass="error"/>
            <label for="register_email">Email</label>
            <sf:input id="register_email" size="15" path="email" placeholder="email"></sf:input>
        </div>
        <div class="input-field">
            <sf:errors path="password" cssClass="error"/>
            <label for="register_password">Password</label>
            <sf:password id="register_password" size="15" maxlength="15" path="password" placeholder="password"></sf:password>
        </div>
        <div class="button-wrapper">
            <button class="button material-element">Register</button>
        </div>
    </sf:form>
</div>