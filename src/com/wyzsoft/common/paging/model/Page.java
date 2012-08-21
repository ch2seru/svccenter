package com.wyzsoft.common.paging.model;

/**
 * Subject : 페이징
 * User: lke
 * Date: 12. 2. 6
 */
public class Page {
    private int firstPage;		//첫번째페이지 <<
    private int prePage;		//이전페이지  <
    private int nextPage;		//다음페이지  >
    private int endPage;		//마지막페이지  >>
    private int startPageNum;	//화면에 나타날 시작페이지번호
    private int endPageNum;		//화면에 나타날 마지막페이지번호

    private int pageByDivide=10;  // 한페이지에 나올 글 수
    private int pagesByDivide=10; // 한페이지당 나올 리스트 갯수[0][1][2]
    private int allDataCount=1;   // 총데이터
    private int currentPage=1;    // 현재 페이지
    private String style;         // 스타일

    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getStartPageNum() {
        return startPageNum;
    }

    public void setStartPageNum(int startPageNum) {
        this.startPageNum = startPageNum;
    }

    public int getEndPageNum() {
        return endPageNum;
    }

    public void setEndPageNum(int endPageNum) {
        this.endPageNum = endPageNum;
    }

    public int getPageByDivide() {
        if(this.pageByDivide==0 )    return 10;
        return pageByDivide;
    }

    public void setPageByDivide(int pageByDivide) {
        this.pageByDivide = pageByDivide;
    }

    public int getPagesByDivide() {
        if(this.pagesByDivide==0 )    return 10;
        return pagesByDivide;
    }

    public void setPagesByDivide(int pagesByDivide) {
        this.pagesByDivide = pagesByDivide;
    }

    public int getAllDataCount() {
        return allDataCount;
    }

    public void setAllDataCount(int allDataCount) {
        this.allDataCount = allDataCount;
    }

    public int getCurrentPage() {
        if(this.currentPage==0 )    return 1;
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
