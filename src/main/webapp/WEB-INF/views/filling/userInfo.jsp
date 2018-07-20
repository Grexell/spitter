<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 14.05.2018
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div>
    <h2>${spitter.username}</h2>
    <security:authorize access="#username == principal?.username">
        <security:authentication property="principal.username" var="login"/>
        <a href="/spitter/edit/${login}">Edit profile</a>
    </security:authorize>
</div>