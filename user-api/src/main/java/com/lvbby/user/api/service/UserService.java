package com.lvbby.user.api.service;

import com.lvbby.user.api.dto.UserDTO;
import com.lvbby.user.api.request.UserRegisterRequest;
import com.lvbby.user.api.response.UserRegisterResponse;

/**
 * Created by lipeng on 16/8/4.
 */
public interface UserService {
    UserRegisterResponse add(UserRegisterRequest userRegisterRequest);

    UserDTO loadById(long id);

    UserDTO loadByName(String name);

    UserDTO loadByNameAndPassword(String name, String password);
}
