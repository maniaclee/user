package com.lvbby.user.test;

import com.lvbby.user.dao.UserMapper;
import com.lvbby.user.dto.UserDTO;
import com.lvbby.user.entity.UserEntity;
import com.lvbby.user.repo.UserRepository;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by peng on 16/2/2.
 */
@SpringBootApplication
@ComponentScan("com.lvbby.user")
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration(exclude = {DataSourceTransactionManagerAutoConfiguration.class, DataSourceAutoConfiguration.class})
@EnableAspectJAutoProxy
@ContextConfiguration(classes = {MybatisTest.class})
public class MybatisTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRepository userRepository;

    @Test
    public void test() {
        print(userMapper.loadById(22));
    }


    @Test
    public void insert() {
        UserDTO entity = new UserDTO();
        entity.setName("ris112");
        entity.setAddTime(new Date());
        print(entity.getId());
        print(userRepository.add(entity));
    }



    private void print(Object p) {
        if (p instanceof Iterable) {
            Iterator i = ((Iterable) p).iterator();
            if (i.hasNext())
                while (i.hasNext())
                    System.out.println(ToStringBuilder.reflectionToString(i.next()));
            else {
                System.out.println(p);
            }
        } else {
            System.out.println(ToStringBuilder.reflectionToString(p));
        }
    }
}
