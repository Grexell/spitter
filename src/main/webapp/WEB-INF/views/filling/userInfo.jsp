<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 14.05.2018
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="left left-1-3 material-box">
    <div class="spitter">
        <div class="spitter-image image" style="background-image: url(/img/${spitter.image})">
        </div>

        <div class="h-text">${spitter.username}</div>
        <security:authorize access="isAuthenticated()">
            <security:authorize access="#username == principal?.username">
                <security:authentication property="principal.username" var="login"/>
                <div class="button-wrapper">
                    <a class="button material-element" href="/spitter/edit/${login}">Edit profile</a>
                </div>
            </security:authorize>
        </security:authorize>
    </div>
</div>