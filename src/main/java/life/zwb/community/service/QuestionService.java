package life.zwb.community.service;

import life.zwb.community.dto.PaginationDTO;
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

    public PaginationDTO list(Integer page, Integer size) {

        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);

        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }

        Integer offset = size * (page - 1);
        List<Question> questions = questionMapper.list(offset,size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions){
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.setId(question.getId());
            BeanUtils.copyProperties(question,questionDTO);  //将question中的属性复制到questionDTO中
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}