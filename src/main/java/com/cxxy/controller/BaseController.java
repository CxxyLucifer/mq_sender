package com.cxxy.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cxxy.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:liuhui
 * Description:
 * Date: 5:09 PM 2018/11/13
 */
public class BaseController {

    public static ResponseEntity<BaseResponse> ok() {
        return ResponseEntity.ok(new BaseResponse(null, 1, "操作成功"));
    }

    public static ResponseEntity<BaseResponse> fail() {
        return ResponseEntity.ok(new BaseResponse(null, -2, "操作失败"));
    }

    /**
     * 获取request
     */
    protected HttpServletRequest getRequestContext() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }
}
