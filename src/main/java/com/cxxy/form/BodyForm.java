package com.cxxy.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Author:liuhui
 * Description:
 * Date: 5:50 PM 2018/11/14
 */
@Data
public class BodyForm implements Serializable{

    private Object body;
}
