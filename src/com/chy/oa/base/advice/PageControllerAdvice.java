package com.chy.oa.base.advice;

import com.chy.oa.base.pluging.Page;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;
//设置AOP管理包路径
@ControllerAdvice(basePackages = "com.chy.oa.core.controller")
public class PageControllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder, HttpServletRequest request){
        binder.registerCustomEditor(Page.class,new PropertyEditorSupport(){
            @Override
            public Object getValue() {
                Page page = (Page) super.getValue();

                if(page.getPage() == null){
                    page.setPage(1);
                }
                page.setPageSize(5);

                //解析request 获得请求链接
                String url = request.getRequestURI();
                String params = request.getQueryString();
                if (params != null && "".equals(params)){
                    url += "?" + params;
                }else{
                    url += "?1=1";
                }
                int index = -1;
                if ((index = url.indexOf("&page=")) != -1){
                    url = url.substring(0,index);
                }
                page.setUrl(url);
                return page;
            }
        });
    }
}
