package life.zwb.community.dto;

import life.zwb.community.model.User;
import lombok.Data;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/12/6 13:56
 **/
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;

}
