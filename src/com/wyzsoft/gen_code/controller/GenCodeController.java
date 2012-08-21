package com.wyzsoft.gen_code.controller;


import com.wyzsoft.common.message.ErrorMsg;
import com.wyzsoft.gen_code.model.GenCode;
import com.wyzsoft.gen_code.service.IGenCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class GenCodeController extends MultiActionController{
    @Autowired private IGenCodeService genCodeService;
	
	//리스트
	@RequestMapping("/gen_code/gen_code_list.wyz")
	public ModelAndView gen_code_list(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/gen_code/gen_code_list");
		mv.addObject("codeList",genCodeService.getList(request.getParameter("search_column"), request.getParameter("search_keyword"), request.getParameter("page_num")));
		mv.addObject("totalCount",genCodeService.getTotalCount(request.getParameter("search_column"), request.getParameter("search_keyword")));
		
		return mv;
	}
	
	//상세페이지
	@RequestMapping("/gen_code/gen_code_info.wyz")
	public ModelAndView gen_code_info(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/gen_code/gen_code_save");
		
		String gen_code="";
		
		if(request.getParameter("gen_code") !=null) gen_code = request.getParameter("gen_code");
		if(request.getAttribute("gen_code") !=null) gen_code = request.getAttribute("gen_code").toString();
		
		mv.addObject("genCode",genCodeService.get(gen_code));
		//DISPLAY FALSE
		mv.addObject("readOnly","true");
        mv.addObject("modifyDisplayNone","style=\"display:none\"");
        
		return mv;
	}
	
	//입력폼
	@RequestMapping("/gen_code/gen_code_form.wyz")
	public ModelAndView gen_code_form(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/gen_code/gen_code_save");
		mv.addObject("genCode",new GenCode());
		//DISPLAY FALSE
        mv.addObject("saveDisplayNone","style=\"display:none\"");
		
		return mv;
	}
	
	//저장
	@RequestMapping("/gen_code/gen_code_save.wyz")
	public ModelAndView gen_code_save(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("genCode")
			GenCode genCode) throws Exception {
		ModelAndView mv = new ModelAndView();
        int result = genCodeService.save(genCode);

		if(result == ErrorMsg.PASS.intValue()){
            //저장성공한 경우
            mv.setViewName("redirect:/gen_code/gen_code_info.wyz");
            mv.addObject("gen_code", genCode.getGen_code());
        }else{
            //저장이 실패한 경우
            mv.addObject("genCode", genCode);
            mv.setViewName("/gen_code/gen_code_save");
            mv.addObject("message",ErrorMsg.message(result));
            //DISPLAY FALSE
            mv.addObject("saveDisplayNone","style=\"display:none\"");
        }

		return mv;
	}
	
	//수정
	@RequestMapping("/gen_code/gen_code_modify.wyz")
	public ModelAndView gen_code_modify(HttpServletRequest request,
            HttpServletResponse response, @ModelAttribute("genCode")
			GenCode genCode) throws Exception {
		ModelAndView mv = new ModelAndView();
		genCodeService.modify(genCode);
		mv.setViewName("redirect:/gen_code/gen_code_list.wyz");
		
		return mv;
	}
	
	//삭제
	@RequestMapping("/gen_code/gen_code_remove.wyz")
	public ModelAndView gen_code_remove(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		genCodeService.remove(request.getParameter("gen_code"));
		mv.setViewName("redirect:/gen_code/gen_code_list.wyz");
		
		return mv;
	}
	


}
