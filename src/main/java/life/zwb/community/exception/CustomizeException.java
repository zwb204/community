package life.zwb.community.exception;

/**
 * @Desc:
 * @Author: zwb
 * @CreateTime: 2019/11/15 9:41
 **/
public class CustomizeException extends RuntimeException {
    private String message;

    public CustomizeException(ICustomizeErrorCode errorCode) {
        this.message = errorCode.getMessage();
    }

    public CustomizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
