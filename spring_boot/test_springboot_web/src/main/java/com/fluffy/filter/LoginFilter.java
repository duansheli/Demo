/**  
 * Project Name:com.ff.mp  
 * File Name:Snippet.java  
 * Package Name:com.ff.mp.filter  
 * Date:2016年8月15日下午4:55:16  
 * Copyright (c) 2016, zhangxin All Rights Reserved.  
 *  
*/

package com.fluffy.filter;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;


/**
 * ClassName:Snippet <br/>
 * Date: 2016年8月15日 下午4:55:16 <br/>
 * 
 * @author root
 * @see
 */

public class LoginFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
//    showParam(request);
    HttpServletRequest req = (HttpServletRequest) request;
    // 取得SESSION中的loginUser对象
    String uri = req.getRequestURI();
      if(StringUtils.startsWith(uri, "/rest/login")){ //对于登录开头的也可以访问
        chain.doFilter(request, response);
        return ;
      // 如果用户没有登录，那么将会直接跳转到登陆页面
      ((HttpServletResponse) response).getWriter().write("<script>window.top.location.href='/rest/login'</script>");
      // ((HttpServletResponse)resp).sendRedirect("/rest/login");

    } else {
      chain.doFilter(request, response);
    }
  }

  @Override
  public void destroy() {
  }
  static void showParam(ServletRequest request){

    HttpServletRequest req = (HttpServletRequest) request;
    System.out.println("showParam");
    Map<String, String[]> map = req.getParameterMap();
    Set<Entry<String, String[]>> set = map.entrySet();
    for (Entry<String, String[]> entry : set) {
      System.out.println(entry.getKey()+"  =++++++=  "+ entry.getValue()[0]);
    }
    System.out.println( "begin " + req.getRequestURL());
    System.out.println(req.getContextPath());
    System.out.println(req.getContextPath());
    System.out.println(req.getLocalAddr());
    System.out.println(req.getLocalName());
    System.out.println(req.getLocalPort());
    System.out.println(req.getPathInfo());
    System.out.println(req.getPathTranslated());
    System.out.println(req.getProtocol());
    System.out.println(req.getQueryString());
    System.out.println(req.getRemoteAddr());
    System.out.println(req.getRemoteHost() + req.getRemotePort() );
    System.out.println(req.getRemoteUser());
    System.out.println(req.getRequestURI());
    System.out.println(req.getScheme());
    System.out.println(req.getServerName());
    System.out.println(req.getServerPort());
    System.out.println(req.getServletPath());
    System.out.println("end");
  }

}
