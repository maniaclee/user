package com.lvbby.user.repo;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.lvbby.user.entity.UserEntity;
import com.lvbby.user.dto.UserDTO;
import com.lvbby.user.dao.UserMapper;



/**
 * Created by lipeng on 2016-08-03 .
 */
@Component
public class UserRepository {

    @Resource
    private UserMapper userMapper;

	public long add(UserDTO entity){
		UserEntity res = convert(entity);
		userMapper.add(res);
		return res.getId();
	}

	public static UserDTO convert(UserEntity src) {
		UserDTO re = new UserDTO();
		re.setId(src.getId());
		re.setName(src.getName());
		re.setSex(src.getSex());
		re.setEmail(src.getEmail());
		re.setPhone(src.getPhone());
		re.setLevel(src.getLevel());
		re.setImageUrl(src.getImageUrl());
		re.setRole(src.getRole());
		re.setEnabled(src.getEnabled());
		re.setPassword(src.getPassword());
		re.setAddTime(src.getAddTime());
		re.setUpdateTime(src.getUpdateTime());
		return re;
    }
	public static UserEntity convert(UserDTO src) {
		UserEntity re = new UserEntity();
		re.setId(src.getId());
		re.setName(src.getName());
		re.setSex(src.getSex());
		re.setEmail(src.getEmail());
		re.setPhone(src.getPhone());
		re.setLevel(src.getLevel());
		re.setImageUrl(src.getImageUrl());
		re.setRole(src.getRole());
		re.setEnabled(src.getEnabled());
		re.setPassword(src.getPassword());
		re.setAddTime(src.getAddTime());
		re.setUpdateTime(src.getUpdateTime());
		return re;
    }

}