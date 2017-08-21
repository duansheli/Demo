
package com.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */
@Controller
public class Hello {
	
	@RequestMapping("q")
	@ResponseBody
	String q(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("---------------------");
		System.out.println("---------------------");
		System.out.println(request.getSession().getId());
		
		return "hello_sessionId";
	}
	@RequestMapping("w")
	@ResponseBody
	String w(HttpServletRequest request,HttpServletResponse response) {
	    System.out.println("---------------------");
	    System.out.println("---------------------");
	    System.out.println(request.getSession(false));
	    
	    return "hello_session";
	}
	
}
