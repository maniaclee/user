package com.lvbby.user.dao;

import com.lvbby.user.entity.UserEntity;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lipeng on 2016-08-03 .
 */
public interface UserMapper {
    long add(UserEntity entity);

    @Select("select * from user where id = #{id}")
    UserEntity loadById(long id);
}
