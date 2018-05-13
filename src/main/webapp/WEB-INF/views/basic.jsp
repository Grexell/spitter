<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>
</head>
<body>
    <div><tiles:insertAttribute name="header"/></div>
    <div>
        <div><tiles:insertAttribute name="left"/></div>
        <div><tiles:insertAttribute name="right"/></div>
    </div>
    <div><tiles:insertAttribute name="footer"/></div>
</body>
</html>
