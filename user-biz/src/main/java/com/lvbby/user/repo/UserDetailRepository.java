package com.lvbby.user.repo;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.lvbby.user.entity.UserDetailEntity;
import com.lvbby.user.dto.UserDetailDTO;
import com.lvbby.user.dao.UserDetailMapper;



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