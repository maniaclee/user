package com.lvbby.user.dao;

import com.lvbby.user.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lipeng on 2016-08-03 .
 */
public interface UserMapper {
    void add(UserEntity entity);


    @Select("select * from user where id = #{id}")
    UserEntity loadById(long id);

    @Select("select * from user where name = #{name}")
    UserEntity loadByName(String name);

    @Select("select * from user where name = #{name} and password=#{password}")
    UserEntity loadByNameAndPassword(@Param("name") String name, @Param("password")String password);
}
