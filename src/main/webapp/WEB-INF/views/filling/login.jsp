<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<form method="post" action="/spitter/login/">
    <div>
        <label for="login_username">Username</label>
        <input type="text" id="login_username" size="15" maxlength="15" name="username"/>
    </div>
    <div>
        <label for="login_password">Password</label>
        <input id="login_password" size="15" maxlength="15" name="password"/>
    </div>
    <div>
        <input type="checkbox" id="remember_me" size="15" maxlength="15" name="_spring_security_remember_me">
        <label for="remember_me">Remember me</label>
    </div>
    <button>login</button>
</form>