package com.zqy.exceptionHandle;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zqy.exceptionHandle.exception.HtmlRuntimeException;
import com.zqy.exceptionHandle.exception.JsonRuntimeException;
import com.zqy.exceptionHandle.model.ErrorInfo;

@ControllerAdvice
public class GlobalExceptionHandler {
	 public static final String DEFAULT_ERROR_VIEW = "error";

	    @ExceptionHandler(value = HtmlRuntimeException.class)
	    public ModelAndView htmlRuntimeException(HttpServletRequest req, HtmlRuntimeException e) throws Exception {
	        ModelAndView mav = new ModelAndView();
	        mav.addObject("exception", e);
	        mav.addObject("url", req.getRequestURL());
	        mav.setViewName(DEFAULT_ERROR_VIEW);
	        return mav;
	    }
	    @ExceptionHandler(value = JsonRuntimeException.class)
	    @ResponseBody
	    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, JsonRuntimeException e) throws Exception {
	        ErrorInfo<String> r = new ErrorInfo<String>();
	        r.setMessage(e.getMessage());
	        r.setCode(ErrorInfo.ERROR);
	        r.setData("Some Data");
	        r.setUrl(req.getRequestURL().toString());
	        return r;
	    }
}
