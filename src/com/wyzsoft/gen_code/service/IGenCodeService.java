package com.wyzsoft.gen_code.service;

import com.wyzsoft.gen_code.model.GenCode;

import java.util.List;

/**
 * Subject : 공통 코드 정보
 */
public interface IGenCodeService {
    //공토코드 리스트
    public List<GenCode> getList(String search_column,String search_keyword, String page_num) throws Exception;
    
    //공토코드 리스트
    public List<GenCode> getList(String search_column,String search_keyword, String page_num, String page_size) throws Exception;
    
    //총데이터 수
    public int getTotalCount(String search_column,String search_keyword) throws Exception;
    
    //공토코드 
    public GenCode get(String gen_code) throws Exception;
    
    //공토코드 저장
    public int save(GenCode genCode) throws Exception;
    
    //공토코드 수정
    public boolean modify(GenCode genCode) throws Exception;
    
    //공토코드 삭제
    public boolean remove(String gen_code) throws Exception;
    
}
