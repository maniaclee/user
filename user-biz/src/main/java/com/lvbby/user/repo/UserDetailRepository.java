package com.lvbby.user.repo;

import com.lvbby.user.api.dto.UserDetailDTO;
import com.lvbby.user.dao.UserDetailMapper;
import com.lvbby.user.entity.UserDetailEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;



/**
 * Created by lipeng on 2016-08-03 .
 */
@Component
public class UserDetailRepository {

    @Resource
    private UserDetailMapper userDetailMapper;

	public long add(UserDetailDTO entity){
		UserDetailEntity res = convert(entity);
		userDetailMapper.add(res);
		return res.getId();
	}

	public static UserDetailDTO convert(UserDetailEntity src) {
		UserDetailDTO re = new UserDetailDTO();
		re.setId(src.getId());
		re.setUserId(src.getUserId());
		return re;
    }
	public static UserDetailEntity convert(UserDetailDTO src) {
		UserDetailEntity re = new UserDetailEntity();
		re.setId(src.getId());
		re.setUserId(src.getUserId());
		return re;
    }

}