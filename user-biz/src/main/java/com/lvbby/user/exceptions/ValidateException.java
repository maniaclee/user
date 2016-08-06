package com.lvbby.user.exceptions;

/**
 * Created by lipeng on 16/8/6.
 */
public class ValidateException extends RuntimeException {

    private Object object;

    public ValidateException(String message) {
        super(message);
    }

    public ValidateException(Object object) {
        super(object == null ? "null" : object.toString());
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
