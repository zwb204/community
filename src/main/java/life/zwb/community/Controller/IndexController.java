package life.zwb.community.Controller;

import life.zwb.community.dto.PaginationDTO;
import life.zwb.community.dto.QuestionDTO;
import life.zwb.community.mapper.QuestionMapper;
import life.zwb.community.mapper.UserMapper;
import life.zwb.community.model.Question;
import life.zwb.community.model.User;
import life.zwb.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/10/22 8:16
 **/

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest httpServletRequest, Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "size",defaultValue = "5")Integer size){
        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null && cookies.length != 0){
            for (Cookie cookie :
                    cookies) {
                if(cookie.getName().equals("token")){
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null){
                        httpServletRequest.getSession().setAttribute("user",user);
                    }
                    break;
                }
            }
        }

        PaginationDTO pagination = questionService.list(page,size);
        model.addAttribute("pagination",pagination);
        return "index";
    }
}
