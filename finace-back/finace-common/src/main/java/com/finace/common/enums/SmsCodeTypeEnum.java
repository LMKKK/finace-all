package com.finace.common.enums;

/**
 * 短信类型
 */
public enum SmsCodeTypeEnum {
    REG("REG", "注册"),
    LOGIN("LOGIN", "登录"),
    UPDATE_PHONE("UPDATE_PHONE", "修改手机号");


    private String message;
    private String code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    SmsCodeTypeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(String code) {
        for (SmsCodeTypeEnum ele : values()) {
            if (ele.getCode().equals(code)) {
                return ele.getMessage();
            }
        }
        return null;
    }
}
