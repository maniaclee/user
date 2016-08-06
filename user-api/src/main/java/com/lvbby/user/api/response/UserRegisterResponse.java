package com.lvbby.user.api.response;

/**
 * Created by lipeng on 16/8/6.
 */
public class UserRegisterResponse extends BaseResponse {
    private UserRegisterCode userRegisterCode;

    public enum UserRegisterCode {
        user_registered(1000, "user registered"),
        param_error(4000, "parameter error");
        int code;
        String desc;

        public static UserRegisterCode of(int code) {
            for (UserRegisterCode userRegisterCode : values())
                if (userRegisterCode.getCode() == code)
                    return userRegisterCode;
            return null;
        }

        UserRegisterCode(int code, String desc) {
            this.code = code;
            this.desc = desc;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

    public UserRegisterCode getUserRegisterCode() {
        return userRegisterCode;
    }

    public void setUserRegisterCode(UserRegisterCode userRegisterCode) {
        this.userRegisterCode = userRegisterCode;
    }
}
