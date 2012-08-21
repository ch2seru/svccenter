package com.wyzsoft.gen_code.service;

import com.wyzsoft.common.message.ErrorMsg;
import com.wyzsoft.gen_code.dao.IGenCodeDao;
import com.wyzsoft.gen_code.model.GenCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Subject : 공통 코드 정보
 * User: lke
 * Date: 12. 2. 14
 */
@Service
public class GenCodeService implements IGenCodeService {
	@Autowired private IGenCodeDao genCodeDao;
	
	public List<GenCode> getList(String search_column, String search_keyword, String page_num) throws Exception {
		return getList(search_column, search_keyword, page_num, null);
	}
	
    public List<GenCode> getList(String search_column, String search_keyword, String page_num, String page_size) throws Exception {
    	Map params = new HashMap();
        int limit1 = 0;
        int limit2 = 10;
        if(page_size != null && !page_num.equals(""))  limit2 = Integer.parseInt(page_size);
        if(page_num != null && !page_num.equals("") && !page_num.equals("1"))  limit1 = (Integer.parseInt(page_num)-1)*limit2 ;
        params.put("limit1",limit1);
        params.put("limit2",limit2);
        params.put("search_column",search_column);
        params.put("search_keyword",search_keyword);
        
        return this.genCodeDao.selectList(params);
    }
    
    public int getTotalCount(String search_column,String search_keyword) throws Exception{
    	Map params = new HashMap();
        params.put("search_column",search_column);
        params.put("search_keyword",search_keyword);
        
        return this.genCodeDao.selectTotalCount(params);
    }
    
    public GenCode get(String gen_code) throws Exception {
		return this.genCodeDao.selectOne(gen_code);
	}

	public int save(GenCode genCode) throws Exception {
        if(this.genCodeDao.checkDuplicate(genCode)>0){
            return ErrorMsg.DUPLICATE.intValue();
        }else{
            if(this.genCodeDao.insert(genCode)>0) return ErrorMsg.PASS.intValue();
            else return ErrorMsg.FAIL.intValue();
        }
	}
	
	public boolean modify(GenCode genCode) throws Exception {
		this.genCodeDao.update(genCode);
		return true;
	}
	
	public boolean remove(String gen_code) throws Exception {
		this.genCodeDao.delete(gen_code);
		return true;
	}

}
