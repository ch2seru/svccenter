package com.wyzsoft.gen_code.dao;

import com.wyzsoft.gen_code.model.GenCode;
import common.SQLSessionBuilder;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Subject : 공통 코드 데이터 가져 오기
 */
@Repository
public class GenCodeDao extends SQLSessionBuilder implements IGenCodeDao {
	private SqlSession sqlSession = null;

    public List<GenCode> selectList(Map params) throws Exception {
        sqlSession =  getSQLSession();
        List<GenCode> list = null;
        try{
            list = sqlSession.selectList("com.wyzsoft.gen_code.dao.sqlMap.GenCode.selectList",params);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }
        
        return list;
    }
    
    public int selectTotalCount(Map params) throws Exception {
        int result = 0;
        sqlSession =  getSQLSession();
        try{
            result = Integer.parseInt(sqlSession.selectOne("com.wyzsoft.gen_code.dao.sqlMap.GenCode.totalCount",params).toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }
        
        return result;
    }
    
    
    public GenCode selectOne(String gen_code) throws Exception {
        sqlSession =  getSQLSession();
        GenCode bean = null;
        try{
            bean = (GenCode)sqlSession.selectOne("com.wyzsoft.gen_code.dao.sqlMap.GenCode.selectOne",gen_code);
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }
        
        return bean;
    }


	public int insert(GenCode genCode) throws Exception {
        int result = 0;
        sqlSession =  getSQLSession();
        try{
            result = sqlSession.insert("com.wyzsoft.gen_code.dao.sqlMap.GenCode.insert", genCode);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }
		return result;
	}
	
	public int update(GenCode genCode) throws Exception {
        int result = 0;
        sqlSession =  getSQLSession();
        try{
            result = sqlSession.update("com.wyzsoft.gen_code.dao.sqlMap.GenCode.update", genCode);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }
        
		return result;
	}
	
	public int delete(String gen_code) throws Exception {
		int result = 0;
        sqlSession =  getSQLSession();
        try{
            result = sqlSession.delete("com.wyzsoft.gen_code.dao.sqlMap.GenCode.delete", gen_code);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }

        return result;
    }

    public int checkDuplicate(GenCode genCode) throws Exception {
        int result = 0;
        sqlSession =  getSQLSession();
        try{
            result = Integer.parseInt(sqlSession.selectOne("com.wyzsoft.gen_code.dao.sqlMap.GenCode.checkDuplicate",genCode).toString());
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            close(sqlSession);
        }

        return result;
    }

}
