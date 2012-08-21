<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script> 
	window.onload = function(){
		//사용여부 디폴트 값
        if("${message}"!=""){
            alert("${message}");
        }
		document.getElementsByName("active")[0].checked=true;
	}
	
    //저장
    function save(){
        //gen_type,gen_code
        if(document.getElementById("gen_type").value==""){
            alert("타입을 입력해주십시오.");
            return;
        }
        if(document.getElementById("gen_code").value==""){
            alert("일반코드를 입력해주십시오.");
            return;
        }

        if(!confirm("저장하시겠습니까?")) return;

        document.saveForm.action="/gen_code/gen_code_save.wyz";
        document.saveForm.submit();
    }

	//수정
    function modify(){
        if(!confirm("수정하시겠습니까?")) return;
        document.saveForm.action="/gen_code/gen_code_modify.wyz";
        document.saveForm.submit();
    }

	//삭제
	function remove(){
        if(!confirm("삭제하시겠습니까?")) return;
		document.saveForm.action="/gen_code/gen_code_remove.wyz";
        document.saveForm.submit();	
	}
</script>