package com.wyzsoft.gen_code.dao;

import com.wyzsoft.gen_code.model.GenCode;

import java.util.List;
import java.util.Map;

/**
 * Subject : 공통 코드 데이터 가져 오기
 */
public interface IGenCodeDao {
	//리스트
    public List<GenCode> selectList(Map params) throws Exception;
    //총데이터수
    public int selectTotalCount(Map params) throws Exception;
   
    //데이터
    public GenCode selectOne(String gen_code)	throws Exception;
    
    //입력
    public int insert(GenCode genCode) throws Exception;
    //수정
    public int update(GenCode genCode) throws Exception;
    //삭제
    public int delete(String gen_code) throws Exception;

    //중복체크
    public int checkDuplicate(GenCode genCode) throws Exception;
}
