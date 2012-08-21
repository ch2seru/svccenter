<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="post" action="/gen_code/gen_code_save.wyz" commandName="genCode" name="saveForm">
    <table>
        <tr>
            <td>일반코드 종류</td>
            <td><form:input path="gen_type" id="gen_type" maxlength="20"></form:input></td>
        </tr>
        <tr>
            <td>일반코드</td>
            <td><form:input path="gen_code" id="gen_code" readOnly="${readOnly}" maxlength="20"></form:input></td>
        </tr>
        <tr>
            <td>설명</td>
            <td><form:input path="description" maxlength="50"></form:input></td>
        </tr>
        <tr>
            <td>사용여부</td>
            <td><form:radiobutton path="active" value="Y" label="Y"/>
            	<form:radiobutton path="active" value="N" label="N"/>
            </td>
        </tr>
        <tr>
            <td>VALUE</td>
            <td><form:input path="gen_value" maxlength="20"></form:input></td>
        </tr>
        <tr>
            <td>VALUE1</td>
            <td><form:input path="gen_value1" maxlength="20"></form:input></td>
        </tr>
        <tr>
            <td>VALUE2</td>
            <td><form:input path="gen_value2" maxlength="20"></form:input></td>
        </tr>
    </table>
</form:form>
<a href="#" onclick="save()" ${modifyDisplayNone} ><img src="/images/bt_frame_save.gif" alt="저장" /></a>
<a href="#" onclick="modify()" ${saveDisplayNone} ><img src="/images/bt_frame_modify.gif" alt="수정" /></a>
<a href="#" onclick="remove()" ${saveDisplayNone} ><img src="/images/bt_frame_del.gif" alt="삭제" /></a>
