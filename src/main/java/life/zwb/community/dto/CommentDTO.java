package life.zwb.community.dto;

import lombok.Data;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/18 11:33
 **/
@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;

}
