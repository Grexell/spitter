<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 5/13/2018
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<div class="container">
    <div class="logo"><a href="/">Spitter</a></div>
    <div class="menu">
        <ul>
            <li><a href="/">Home</a></li>
            <security:authorize access="isAnonymous()">
                <li><a href="/spitter/login">Login</a></li>
                <li><a href="/spitter/register?new">Register</a></li>
            </security:authorize>

            <security:authorize access="isAuthenticated()">
                <security:authentication property="principal.username" var="login"/>
                <li><a href="/spitter/${login}/spittle/">Write</a></li>
                <li><a href="/spitter/${login}">Profile</a></li>
                <li><a href="/spitter/logout">Logout</a></li>
            </security:authorize>

        </ul>
    </div>
</div>