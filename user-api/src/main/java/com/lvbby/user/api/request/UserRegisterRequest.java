package com.lvbby.user.api.request;

import com.lvbby.user.api.dto.UserDTO;

import java.io.Serializable;

/**
 * Created by lipeng on 16/8/6.
 */
public class UserRegisterRequest implements Serializable {
    private static final long serialVersionUID = -7713588915460734868L;
    private UserDTO userDTO;

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
