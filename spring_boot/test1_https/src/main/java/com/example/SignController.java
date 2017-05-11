/**
 * 
 */
package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SignController {

  @ResponseBody
  @RequestMapping("/aaa")
  public String getSign() {
    String msg = "hello_https_world";
    System.out.println(msg);
    return msg;
  }

}
