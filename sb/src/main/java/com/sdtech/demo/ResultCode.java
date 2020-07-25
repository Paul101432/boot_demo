package com.sdtech.demo;

/**
 * @Description
 * @Date 2020/3/6 15:48
 * @Created by Hrz
 */
public enum ResultCode  {
    SUCCESS(200, "操作成功"),
    FAILURE(400, "请求参数错误"),
    UN_AUTHORIZED(401, "权限认证失败"),
    REQ_REJECT(403, "请求资源不可用"),
    REQ_NOT_FOUND(404, "请求资源不存在"),
    REQ_LOCK (423, "请求资源被锁定"),
    SERVER_ERR (500, "服务错误"),
    SERVER_STOP (503, "服务暂不可用")  ;

    final int code;
    final String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    private ResultCode(final int code, final String msg) {
        this.code = code;
        this.msg = msg;
    }
}
