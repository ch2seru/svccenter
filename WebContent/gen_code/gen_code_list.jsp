<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- <검색> -->
<form name="searchForm" metdod="post" action="/gen_code/gen_code_list.wyz">
<input type="hidden" name="page_num" id="page_num" value="${param.page_num}"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td style="padding-top:20px;padding-bottom:8px;" id="search_text">
            <table width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td width="10%"> Total : ${totalCount} &nbsp; Page : <c:choose><c:when test="${param.page_num eq null}">1</c:when><c:otherwise>${param.page_num}</c:otherwise></c:choose>
                    </td>
                    <td width="90%" align="right" >
                        <select style="widht:78px;height:24px;" name="search_column" id="search_column">
                            <option value="gen_type">종류</option>
                            <option value="gen_code">일반코드 </option>
                            <option value="description">설명 </option>
                        </select>&nbsp;<input type="text" size="15" style="width:130px; height:19px;vertical-align: top" id="search_keyword" name="search_keyword" value="${param.search_keyword}" onchange="changeKeyword()"/>
                    <%--</td>--%>
                    <%--<td width="10%" align="right">--%><a href="Javascript:search()"><img src="/images/btn_search.gif" alt="검색" width="49px" height="20" align="absmiddle" /></a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
</form>
<!-- </검색> -->
<!-- <리스트> -->
<table class="list">
<thead>
<tr>
    <th width="20%" style="border-left: #d6d6d6 solid 1px">종류</th>
    <th width="2px"><img src="/images/board_title_box_bar.gif" width="2px" alt="" /></th>
	<th width="10%">일반코드</th>
    <th width="2px"><img src="/images/board_title_box_bar.gif" width="2px" align="absmiddle" alt="" /></th>
	<th width="30%">설명</th>
    <th width="2px"><img src="/images/board_title_box_bar.gif" width="2px" align="absmiddle" alt="" /></th>
	<th width="10%">코드값</th>
    <th width="2px"><img src="/images/board_title_box_bar.gif" width="2px" align="absmiddle" alt="" /></th>
	<th width="10%">코드값1</th>
    <th width="2px"><img src="/images/board_title_box_bar.gif" width="2px" align="absmiddle" alt="" /></th>
	<th width="10%">코드값2</th>
    <th width="2px"><img src="/images/board_title_box_bar.gif" width="2px" align="absmiddle" alt="" /></th>
	<th width="10%" style="border-right: #d6d6d6 solid 1px;">사용여부</th>
</tr>
</thead>
<tbody>
<tr style="height: 1px">
    <td colspan="13" bgcolor="#f1f1f1"></td>
</tr>
<c:forEach varStatus="num" var="genCode" items="${codeList}">
<tr onMouseOver="this.style.background='#f4f4f4'" onMouseOut="this.style.background=''" onclick="viewInfo('${genCode.gen_code}')" style="cursor:pointer;">
	<td>${genCode.gen_type}</td>
    <td></td>
	<td>${genCode.gen_code}</td>
    <td></td>
	<td>${fn:substring(genCode.description, 0, 10)}...</td>
    <td></td>
	<td>${genCode.gen_value}</td>
    <td></td>
	<td>${genCode.gen_value1}</td>
    <td></td>
	<td>${genCode.gen_value2}</td>
    <td></td>
	<td align="center">${genCode.active}</td>
</tr>
<tr style="height: 1px">
    <td class="board_txt_bg" style="background: url('/images/board_dotted.gif') repeat-x" colspan="13"></td>
</tr>
</c:forEach>
</tbody>
</table>

<!-- </리스트> -->
<!-- <페이징> -->
<!-- totalCount:총 데이터 개수 -->
<!-- currentPage:현재 페이지-->
<!-- pageSize:한화면에 보일 데이터 개수 -->
<c:import url="/common/include/paging.jsp">
    <c:param name="totalCount" value="${totalCount}"/>
    <c:param name="currentPage" value="${param.page_num}"/>
</c:import>
<!-- </페이징> -->
<!-- <링크> -->
<form name="linkForm"  action="/gen_code/gen_code_info.wyz" metdod="post">
    <input type="hidden" name="gen_code"/>
</form>
<!-- </링크> -->
