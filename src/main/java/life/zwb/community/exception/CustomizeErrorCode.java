package life.zwb.community.exception;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/15 10:02
 **/
public enum CustomizeErrorCode implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("你找的问题不存在，请换一个试试");

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
