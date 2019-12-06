package life.zwb.community.dto;

import life.zwb.community.model.User;
import lombok.Data;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/10/25 14:50
 **/
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
