package com.cxxy.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 * Author:liuhui
 * Description:
 * Date: 5:50 PM 2018/11/14
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BodyForm {

    @NotBlank(message = "body不能为空")
    private String body;
}
