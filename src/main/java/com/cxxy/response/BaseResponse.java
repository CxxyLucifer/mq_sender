package com.cxxy.response;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * Author:liuhui
 * Description:
 * Date: 5:53 PM 2018/11/13
 */
@Value
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {

    /**
     * 返回数据: 可选
     * - 数据类型由各接口自行定义(泛型)
     * - 一般只在操作成功时返回, 包括
     * -   查询结果
     * -   修改(含增/删/改)结果
     */
    private final T data;

    /**
     * 错误代码: 可选
     * - 客户端需要根据服务端的错误代码进行处理(比如, 下单时订单中心返回用户未设置收货地址错误, 客户端此时需要引导用户设置收货地址)
     */
    private final Integer status;

    /**
     * 操作结果提示语: 可选
     * - 支持国际化
     * - 可直接展示给用户
     */
    private final String message;
}
