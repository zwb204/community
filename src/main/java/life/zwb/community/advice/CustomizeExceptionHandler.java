package life.zwb.community.advice;

import com.alibaba.fastjson.JSON;
import life.zwb.community.dto.ResultDTO;
import life.zwb.community.exception.CustomizeErrorCode;
import life.zwb.community.exception.CustomizeException;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/11 15:31
 **/
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String contentType = httpServletRequest.getContentType();
        if ("application/json".equals(contentType)){
            ResultDTO resultDTO;
            // 返回JSON
            if (e instanceof CustomizeException){
                resultDTO = ResultDTO.errorOf((CustomizeException) e);
            } else {
                resultDTO = ResultDTO.errorOf(CustomizeErrorCode.SYS_ERROR);
            }
            try {
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(200);
                httpServletResponse.setCharacterEncoding("utf-8");
                PrintWriter writer = httpServletResponse.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe){

            }
            return null;
        } else {
            // 错误页面跳转
            if (e instanceof CustomizeException){
                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message",CustomizeErrorCode.SYS_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
