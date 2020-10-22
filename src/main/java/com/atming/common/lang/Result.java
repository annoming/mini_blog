package com.atming.common.lang;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Annoming
 * @Date: 2020/10/22
 * @Time: 22:12
 * @Description
 */
@Data
public class Result implements Serializable {
    // 200为正常数据，400为异常数据
    private int code;
    private String msg;
    private Object data;

    public static Result success(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
