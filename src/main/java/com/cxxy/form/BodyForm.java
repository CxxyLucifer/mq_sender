package com.cxxy.form;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Author:liuhui
 * Description:
 * Date: 5:50 PM 2018/11/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BodyForm {

    private Object body;
}
