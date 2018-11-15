package com.cxxy.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Author:liuhui
 * Description:
 * Date: 9:18 AM 2018/11/14
 */
@Data
public class MessageForm implements Serializable{

    @NotBlank(message = "内容不能为空")
    private String body;
}
