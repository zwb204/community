package life.zwb.community.controller;

import life.zwb.community.dto.CommentCreateDTO;
import life.zwb.community.dto.CommentDTO;
import life.zwb.community.dto.QuestionDTO;
import life.zwb.community.service.CommentService;
import life.zwb.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/6 13:25
 **/
@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Long id, Model model){
        QuestionDTO questionDTO = questionService.getById(id);
        List<CommentDTO> comments= commentService.listByQuestionId(id);
        //累加阅读数
        questionService.incView(id);
        model.addAttribute("questionDTO",questionDTO);
        model.addAttribute("comments",comments);
        return "question";
    }
}
