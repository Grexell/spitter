<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 07.07.2018
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="left left-1-3 material-box">
    <h1 class="h-text">Edit info</h1>
    <sf:form modelAttribute="spitter" action="/spitter/edit/${spitter.username}" method="post" enctype="multipart/form-data" class="form">
        <div class="input-field">
            <sf:errors path="email" cssClass="error"/>
            <label for="register_email">Email</label>
            <sf:input id="register_email" size="15" path="email" placeholder="email"></sf:input>
        </div>
        <div class="input-field">
            <sf:errors path="password" cssClass="error"/>
            <label for="register_password">Password</label>
            <sf:password id="register_password" size="15" maxlength="15" path="password"
                         placeholder="Your password"></sf:password>
        </div>
        <div class="button-wrapper">
            <input type="file" name="file"/>
        </div>
        <div class="button-wrapper">
            <button class="button material-element">Save</button>
        </div>
    </sf:form>
</div>