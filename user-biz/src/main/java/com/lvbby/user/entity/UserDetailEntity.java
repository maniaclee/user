package com.lvbby.user.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by lipeng on 2016-08-03 .
 */
public class UserDetailEntity implements Serializable {
    private static final long serialVersionUID = -1;

    /*  */
    private long id;
    /*  */
    private long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}