<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
    <title><tiles:getAsString name="title"/></title>

    <link rel="stylesheet" type="text/css" href="/resources/style.css"/>
</head>
<body>
    <div class="wrapper">
        <div class="header"><tiles:insertAttribute name="header"/></div>
        <div class="content container">
            <div class="sidebar"><tiles:insertAttribute name="left"/></div>
            <div class="article"><tiles:insertAttribute name="right"/></div>
        </div>
        <div class="footer"><tiles:insertAttribute name="footer"/></div>
    </div>
</body>
</html>
