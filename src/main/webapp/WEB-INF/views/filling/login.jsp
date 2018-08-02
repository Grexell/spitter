<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="left left-1-3 material-box">
    <h1 class="h-text">Login</h1>
    <form class="form login-form" method="post" action="/spitter/login/">
        <div class="input-field">
            <label for="login_username">Username</label>
            <input type="text" id="login_username" size="15" maxlength="15" name="username" placeholder="username"/>
        </div>
        <div class="input-field">
            <label for="login_password">Password</label>
            <input type="password" placeholder="password" id="login_password" size="15" maxlength="15" name="password"/>
        </div>
        <div class="input-field">
            <input type="checkbox" id="remember_me" size="15" maxlength="15" name="_spring_security_remember_me">
            <label for="remember_me">Remember me</label>
        </div>
        <div class="button-wrapper">
            <button class="button material-element">Login</button>
        </div>
    </form>
</div>