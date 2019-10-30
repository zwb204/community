package life.zwb.community.service;

import life.zwb.community.dto.QuestionDTO;
import life.zwb.community.mapper.QuestionMapper;
import life.zwb.community.mapper.UserMapper;
import life.zwb.community.model.Question;
import life.zwb.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/10/25 14:55
 **/
@Service
public class QuestionService {

    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.setId(question.getId());
            BeanUtils.copyProperties(question,questionDTO);  //将question中的属性复制到questionDTO中
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
