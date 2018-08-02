<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title><tiles:getAsString name="title"/></title>
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css"/>
</head>
<body>
<div class="container flex-container column-flex-container">
    <div class="header flex-container row-flex-container material-box">
        <tiles:insertAttribute name="header"/>
    </div>
    <div class="content row-flex-container">
        <tiles:insertAttribute name="left"/>
        <tiles:insertAttribute name="right"/>
    </div>
    <div class="footer">
        <tiles:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>
