<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 5/13/2018
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <c:forEach items="${spittles}" var="spittle">
        <div>
            <div><a href="/spitter/${spittle.spitter.username}">${spittle.spitter.username}</a></div>
            <div><fmt:formatDate value="${spittle.time}" pattern="hh:mma MMM d, yyyy"/> </div>
            <div>${spittle.message}</div>
        </div>
    </c:forEach>
</div>
