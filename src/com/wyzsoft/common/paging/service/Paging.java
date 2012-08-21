package com.wyzsoft.common.paging.service;

import com.wyzsoft.common.paging.model.Page;

/**
 * Subject : 페이징 처리
 * User: lke
 * Date: 12. 2. 6
 */
public class Paging {
    private Page page;

    public void setPage(Page page) {
        this.page = page;
    }

    public Page getPaging(){
        int allPage=0; 						//총페이지
        int startPageNum=1; 				//화면에 나타날 시작페이지번호
        int endPageNum=this.page.getPagesByDivide(); 	//화면에 나타날 마지막페이지번호
        int firstPage=-1; 					//첫번째페이지 <<
        int endPage=-1;   					//마지막페이지  >>
        int prePage=-1;   					//이전페이지  <
        int nextPage=-1;  					//다음페이지  >

        //총페이지  구하기
        if(this.page.getAllDataCount()%this.page.getPageByDivide()==0) {
            allPage= this.page.getAllDataCount()/this.page.getPageByDivide();
        }else{
            allPage=this.page.getAllDataCount()/this.page.getPageByDivide()+1;
        }


        if(allPage>this.page.getPagesByDivide())//이전 이후 페이지가 있을경우
        {
            //화면에 나타날 시작페이지번호, 마지막페이지번호 구하기
            if(this.page.getCurrentPage()%this.page.getPagesByDivide()==0){
                startPageNum= (this.page.getCurrentPage()/this.page.getPagesByDivide()-1)*this.page.getPagesByDivide()+1;
                endPageNum=(this.page.getCurrentPage()/this.page.getPagesByDivide())*this.page.getPagesByDivide();
            }else{
                startPageNum= this.page.getCurrentPage()/this.page.getPagesByDivide()*this.page.getPagesByDivide()+1;
                endPageNum=(this.page.getCurrentPage()/this.page.getPagesByDivide()+1)*this.page.getPagesByDivide();
            }

            if(endPageNum>allPage) {
                endPageNum=allPage;
            }else{
                nextPage=endPageNum+1;
            }
            firstPage=1;
            endPage=allPage;
            prePage=startPageNum-1;

            if(this.page.getCurrentPage()<=this.page.getPagesByDivide()){
                firstPage=-1;
                prePage=-1;
            }

        }else{ //이전 이후 페이지가 없을 경우
            endPageNum=allPage;
        }

        if(endPage==endPageNum) endPage=-1;

        this.page.setEndPage(endPage);
        this.page.setEndPageNum(endPageNum);
        this.page.setFirstPage(firstPage);
        this.page.setNextPage(nextPage);
        this.page.setPrePage(prePage);
        this.page.setStartPageNum(startPageNum);

        return page;
    }
    
    public String print(){
        StringBuffer sb = new StringBuffer();
        Page page = getPaging();

        //sb.append("<span class='"+page.getStyle()+"'>");
        if(page.getFirstPage()>-1)  sb.append("<a href='#' onClick='movePage("+page.getFirstPage()+")'>");
        sb.append("◀◀&nbsp;");
        if(page.getFirstPage()>-1)  sb.append("</a>");

        //sb.append("<span class='"+page.getStyle()+"'>");
        if(page.getPrePage()>-1)  sb.append("<a href='#' onClick='movePage("+page.getPrePage()+")'>");
        sb.append("◀&nbsp;");
        if(page.getPrePage()>-1)  sb.append("</a>");

        for(int i=page.getStartPageNum();i<=page.getEndPageNum();i++){
            if(i==page.getCurrentPage())  sb.append("<strong>"+i+"</strong>&nbsp;");
            else    sb.append("<a href='#' onClick='movePage("+i+")'>"+i+"</a>&nbsp;");
        }

        if(page.getNextPage() == -1){
            for(int i=page.getEndPageNum()+1;i<=page.getStartPageNum()+9;i++){
                sb.append(i+"&nbsp;");
            }
        }else{
            for(int i=page.getEndPageNum()+1;i<=page.getNextPage()-1;i++){
                sb.append(i+"&nbsp;");
            }
        }

        //sb.append("<span class='"+page.getStyle()+"'>");
        if(page.getNextPage()>-1)  sb.append("<a href='#' onClick='movePage("+page.getNextPage()+")'>");
        sb.append("▶&nbsp;");
        if(page.getNextPage()>-1)  sb.append("</a>");

        //sb.append("<span class='"+page.getStyle()+"'>");
        if(page.getEndPage()>-1)  sb.append("<a href='#' onClick='movePage("+page.getEndPage()+")'>");
        sb.append("▶▶");
        if(page.getEndPage()>-1)  sb.append("</a>");

        return sb.toString();
    }
}
