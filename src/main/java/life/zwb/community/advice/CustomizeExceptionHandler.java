package life.zwb.community.advice;

import life.zwb.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/11 15:31
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable ex, Model model) {
        if (ex instanceof CustomizeException){
            model.addAttribute("message", ex.getMessage());
        } else {
            model.addAttribute("message","服务器要歇歇啦！！！");
        }
        return new ModelAndView("error");
    }
}
