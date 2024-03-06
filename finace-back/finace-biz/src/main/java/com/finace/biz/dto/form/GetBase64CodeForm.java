package com.finace.biz.dto.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class GetBase64CodeForm {

    @ApiModelProperty("客户端id")
    @NotBlank(message = "客户端id不能为空")
    @Pattern(regexp = "^[0-9a-zA-Z]{6,32}$", message = "客户端id非法")
    private String clientId;

}
