package com.lvbby.user.service.impl;

import com.lvbby.user.api.dto.UserDTO;
import com.lvbby.user.api.request.UserRegisterRequest;
import com.lvbby.user.api.response.BaseResponse;
import com.lvbby.user.api.response.UserRegisterResponse;
import com.lvbby.user.api.service.UserService;
import com.lvbby.user.repo.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by lipeng on 16/8/4.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserRegisterResponse add(UserRegisterRequest userRegisterRequest) {

        if (userRegisterRequest == null || userRegisterRequest.getUserDTO() == null || StringUtils.isBlank(userRegisterRequest.getUserDTO().getName()))
            return fail(UserRegisterResponse.UserRegisterCode.param_error, userRegisterRequest);
        UserDTO userDTO = userRegisterRequest.getUserDTO();
        userDTO.setName(userDTO.getName().trim());
        try {
            long userId = userRepository.add(userDTO);
            UserRegisterResponse success = BaseResponse.success(UserRegisterResponse.class);
            success.setUserId(userId);
            return success;
        } catch (Exception e) {
            return fail(UserRegisterResponse.UserRegisterCode.user_registered, userRegisterRequest);
        }
    }

    @Override
    public UserDTO loadById(long id) {
        return userRepository.loadById(id);
    }

    @Override
    public UserDTO loadByName(String name) {
        return userRepository.loadByName(name);
    }

    @Override
    public UserDTO loadByNameAndPassword(String name, String password) {
        return userRepository.loadByNameAndPassword(name, password);
    }

    private UserRegisterResponse fail(UserRegisterResponse.UserRegisterCode userRegisterCode, UserRegisterRequest userRegisterRequest) {
        UserRegisterResponse fail = BaseResponse.fail(UserRegisterResponse.class);
        fail.setResultCode(userRegisterCode);
        return fail;
    }

}
