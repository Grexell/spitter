<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 07.07.2018
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<sf:form modelAttribute="spittle" action="/spitter/${spitter}/spittle/send" method="post">
    <sf:errors path="message" cssClass="error"/>
    <sf:textarea path="message"></sf:textarea>
    <sf:button></sf:button>
</sf:form>