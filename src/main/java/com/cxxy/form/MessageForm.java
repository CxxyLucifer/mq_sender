package com.cxxy.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * Author:liuhui
 * Description:
 * Date: 9:18 AM 2018/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageForm {

    @NotBlank(message = "id不能为空")
    private String id;

    @NotBlank(message = "body不能为空")
    private String body;
}
