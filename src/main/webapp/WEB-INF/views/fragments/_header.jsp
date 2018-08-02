<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 5/13/2018
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- <%@taglib uri="" --%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<c:url var="contextPath" value="/"/>
<div class="logo menu-item-style"><a href="${contextPath}">Spitter</a></div>
<div class="menu">
    <ul><li class="menu-item menu-item-style"><a href="${contextPath}">Home</a></li><security:authorize access="isAnonymous()"><li class="menu-item menu-item-style"><a href="${contextPath}spitter/login">Login</a></li><li class="menu-item menu-item-style"><a href="${contextPath}spitter/register?new">Register</a></li></security:authorize><security:authorize access="isAuthenticated()"><security:authentication property="principal.username" var="login"/><li class="menu-item menu-item-style"><a href="/spitter/${login}/spittle/">Write</a></li><li class="menu-item menu-item-style"><a href="/spitter/${login}">Profile</a></li><li class="menu-item menu-item-style"><a href="/spitter/logout">Logout</a></li></security:authorize></ul>
</div>
<%--<div class="menu">--%>
    <%--<ul>--%>
        <%--<li><a href="${contextPath}">Home</a></li>--%>
        <%--<security:authorize access="isAnonymous()">--%>
            <%--<li><a href="${contextPath}spitter/login">Login</a></li>--%>
            <%--<li><a href="${contextPath}spitter/register?new">Register</a></li>--%>
        <%--</security:authorize>--%>

        <%--&lt;%&ndash;<security:authorize access="isAuthenticated()">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<security:authentication property="principal.username" var="login"/>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li><a href="/spitter/${login}/spittle/">Write</a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li><a href="/spitter/${login}">Profile</a></li>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<li><a href="/spitter/logout">Logout</a></li>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</security:authorize>&ndash;%&gt;--%>

    <%--</ul>--%>
<%--</div>--%>
