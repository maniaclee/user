package com.lvbby.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lipeng on 16/8/4.
 */
@SpringBootApplication
@ComponentScan
@ImportResource("provider.xml")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        System.out.println(new SimpleDateFormat("[yyyy-MM-dd HH:mm:ss]").format(new Date()) + " ======== server started! =========");
    }
}
