package com.lvbby.user.api.response;

import java.io.Serializable;

/**
 * Created by lipeng on 16/8/6.
 */
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = -2058986820704858653L;
    private boolean success;

    public static <T extends BaseResponse> T success(Class<T> clz) {
        return create(clz, true);
    }

    public static <T extends BaseResponse> T fail(Class<T> clz) {
        return create(clz, false);
    }

    private static <T extends BaseResponse> T create(Class<T> clz, boolean success) {
        try {
            T t = clz.newInstance();
            t.success = success;
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
