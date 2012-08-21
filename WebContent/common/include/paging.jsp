<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="pageInfo" class="com.wyzsoft.common.paging.model.Page"/>
<jsp:useBean id="manager" class="com.wyzsoft.common.paging.service.Paging"/>
<jsp:setProperty name="pageInfo" property="allDataCount" value="${param.totalCount}"/>
<jsp:setProperty name="pageInfo" property="currentPage" value="${param.currentPage}"/>
<jsp:setProperty name="pageInfo" property="style" value="txt_8pt"/>
<c:if test="${param.page_size ne null}">
    <jsp:setProperty name="pageInfo" property="pageByDivide" value="${param.pageSize}"/>
</c:if>
<c:if test="${param.style ne null}">
    <jsp:setProperty name="pageInfo" property="style" value="${param.style}"/>
</c:if>
<jsp:setProperty name="manager" property="page" value="${pageInfo}"/>
<c:set var="paging" value="<%=manager.print() %>"/>

<div id="paging">
${paging}
</div>
