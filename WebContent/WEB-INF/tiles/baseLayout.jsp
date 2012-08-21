<%--
  Subject : 
  User: lke
  Date: 12. 4. 3
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="/common/css/style.css" type="text/css" />
    <%--<link rel="stylesheet" href="/common/css/base_201008.css" type="text/css" />--%>
    <link rel="stylesheet" href="/common/css/header.css" type="text/css" />
    <tiles:insertAttribute name="head" />
</head>
<body>
<div id="wapper">
    <!--<헤더>-->
    <div id="header">
        <tiles:insertAttribute name="header" />
    </div>
    <!--</헤더>-->
    <!--<네비게이션>-->
    <div id="nav">
        <tiles:insertAttribute name="menu" />
    </div>
    <!--</네비게이션>-->
    <!--<사이드바>-->
    <div id="aside">
        <tiles:insertAttribute name="aside" />
    </div>
    <!--</사이드바>-->
    <!--<콘텐츠>-->
    <div id="section">
        <tiles:insertAttribute name="body" />
    </div>
    <!--</콘텐츠>-->
    <!--<풋터>-->
    <div id="footer">
        <tiles:insertAttribute name="footer" />
    </div>
    <!--</풋터>-->
</div>
</body>
</html>