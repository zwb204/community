package life.zwb.community.controller;

import life.zwb.community.dto.CommentCreateDTO;
import life.zwb.community.dto.ResultDTO;
import life.zwb.community.exception.CustomizeErrorCode;
import life.zwb.community.mapper.CommentMapper;
import life.zwb.community.model.Comment;
import life.zwb.community.model.User;
import life.zwb.community.service.CommentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/18 11:17
 **/
@Controller
public class CommentController {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;

    @ResponseBody    //将对象自动序列化为json，发回前端
    @RequestMapping(value = "/comment",method = RequestMethod.POST)
    public Object post(@RequestBody CommentCreateDTO commentCreateDTO,
                       HttpServletRequest httpServletRequest){  //接受json格式的数据，转化为对象
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if (user == null){
            return ResultDTO.errorOf(CustomizeErrorCode.NO_LOGIN);
        }

        if (commentCreateDTO == null || StringUtils.isBlank(commentCreateDTO.getContent())){
            return ResultDTO.errorOf(CustomizeErrorCode.CONTENT_IS_EMPTY);
        }
        Comment comment = new Comment();
        comment.setParentId(commentCreateDTO.getParentId());
        comment.setContent(commentCreateDTO.getContent());
        comment.setType(commentCreateDTO.getType());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        comment.setCommentator(user.getId());
        comment.setLikeCount(0L);
        commentService.insert(comment);
        return ResultDTO.okOf();
    }
}
