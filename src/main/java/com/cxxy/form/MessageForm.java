package com.cxxy.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author:liuhui
 * Description:
 * Date: 9:18 AM 2018/11/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageForm {

    private String body;
}
