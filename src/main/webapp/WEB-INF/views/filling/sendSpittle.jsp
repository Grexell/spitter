<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: demes
  Date: 07.07.2018
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@page isELIgnored="false" %>
<div class="right right-2-3 material-box">
    <h1 class="h-text">Write</h1>
    <sf:form modelAttribute="spittle" action="/spitter/${spitter}/spittle/send" method="post" class="form">
        <div class="input-field">
            <sf:textarea path="message"></sf:textarea>
        </div>
        <div class="button-wrapper">
            <button class="button material-element">Submit</button>
        </div>
        <%--<sf:errors path="message" cssClass="error"/>--%>
    </sf:form>
</div>