
package com.fluffy.vo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloControl {

    @RequestMapping("ha")
    @ResponseBody
    public String ha(HttpServletRequest req, HttpServletResponse resp) {
        return "successss";
    }

    @RequestMapping("hb")
    @ResponseBody
    public String hb(@Validated User user) {
        System.out.println("----------  当参数不匹配时，则不会进入该方法，  则请求直接被拒绝了。 前后端校验互不影响");
        return "successss";
    }
    
    @RequestMapping("hc")
    @ResponseBody
    public String hb(@Valid User user, BindingResult result, Model model) {
        model.addAttribute("demo", user);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors) {
                System.out.println("对象user属性： " +5 + "有错误 ");
                System.out.println(error.getCode() + "---" + error.getArguments().getClass() + "---" + error.getDefaultMessage());
            }

            return "demo";
        }
        return "successss";
    }
    
    public void MethodArgumentNotValidException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
        logger.error( ":" + CommonUtil.getHttpClientInfo(request), ex);
        MethodArgumentNotValidException c = (MethodArgumentNotValidException) ex;
        List<ObjectError> errors =c.getBindingResult().getAllErrors();
        StringBuffer errorMsg=new StringBuffer();
        errors.stream().forEach(x -> errorMsg.append(x.getDefaultMessage()).append(";"));
        pouplateExceptionResponse(response, HttpStatus.INTERNAL_SERVER_ERROR, errorMsg.toString());
    }


 private void pouplateExceptionResponse(HttpServletResponse response, HttpStatus errorCode, String errorMessage) {
        try {
            response.sendError(errorCode.value(), errorMessage);
        } catch (IOException e) {
            logger.error("failed to populate response error", e);
        }
    }
    
    

}
