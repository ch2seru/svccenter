<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	window.onload = function(){
	    //검색어 포커스
	    document.getElementById("search_keyword").focus();

    	//검색 컬럼
	    var column = document.getElementById("search_column");
	    for(var i=0; i<column.options.length; i++)
	    {
	        if(column.options.item(i).value == "${param.search_column}"){
	            column.options.item(i).selected = true;
	        }
	    }
	}
    
	//하단의 페이지 클릭시 페이지이동
	function movePage(pageNum)
	{
	    document.getElementById('page_num').value = pageNum;
	    search();
	}
    
	//검색
    function search(){
        document.searchForm.submit();
    }

    //검색어 변경시 현제 페이지 초기화
    function changeKeyword(){
        document.getElementById('page_num').value = "1";
        search();
    }
    
	//상세페이지
    function viewInfo(genCode){
    	document.linkForm.gen_code.value=genCode;
    	document.linkForm.submit();
    }
</script>