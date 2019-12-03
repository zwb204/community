package life.zwb.community.enums;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/18 16:00
 **/
public enum CommentTypeEnum {

    QUESTION(1),
    COMMENT(2);

    private Integer type;

    CommentTypeEnum(Integer type) {
        this.type = type;
    }

    public static boolean isExist(Integer type) {
        for (CommentTypeEnum commentTypeEnum : CommentTypeEnum.values()){
            if (commentTypeEnum.getType() == type){
                return true;
            }
        }
        return false;
    }

    public Integer getType() {
        return type;
    }
}
