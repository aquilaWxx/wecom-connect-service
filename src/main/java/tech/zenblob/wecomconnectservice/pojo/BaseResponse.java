package tech.zenblob.wecomconnectservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MSG = "success";

    public static final int BAD_REQUEST = 400;
    public static final String BAD_REQUEST_MSG = "请求参数错误";

    public static final int UNAUTHORIZED = 401;
    public static final String UNAUTHORIZED_MSG = "未授权或登录已过期";

    public static final int FORBIDDEN = 403;
    public static final String FORBIDDEN_MSG = "没有权限访问";

    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final String INTERNAL_SERVER_ERROR_MSG = "服务器内部错误";

    public static final int SERVICE_UNAVAILABLE = 503;
    public static final String SERVICE_UNAVAILABLE_MSG = "服务不可用，服务器暂时过载或维护";

    public static final int TOKEN_EXPIRED = 1002;
    public static final String TOKEN_EXPIRED_MSG = "Token已过期";

    public static final int TOKEN_INVALID = 1003;
    public static final String TOKEN_INVALID_MSG = "Token无效";

    public static final int BUSINESS_ERROR = 1004;
    public static final String BUSINESS_ERROR_MSG = "服务异常";

    public static final int DATA_NOT_EXIST = 1005;
    public static final String DATA_NOT_EXIST_MSG = "数据不存在";

    public static final int DATA_ALREADY_EXIST = 1006;
    public static final String DATA_ALREADY_EXIST_MSG = "数据已存在";

    private int code;
    private String msg;
    private T data;

    public static BaseResponse<Object> success() {
        BaseResponse<Object> response = new BaseResponse<>();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MSG);
        response.setData(null);
        return response;
    }

    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> success(int code, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(SUCCESS_MSG);
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> success(int code, String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static <T> BaseResponse<T> failed(int code, String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> BaseResponse<T> failed(String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(500);
        response.setMsg(msg);
        return response;
    }

    public static <T> BaseResponse<T> failed(int code, String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }


}

