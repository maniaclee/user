package com.lvbby.user.service.impl;

import com.lvbby.user.api.dto.UserDTO;
import com.lvbby.user.api.service.UserService;
import com.lvbby.user.repo.UserRepository;
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
    public long add(UserDTO entity) {
        return userRepository.add(entity);
    }
}
