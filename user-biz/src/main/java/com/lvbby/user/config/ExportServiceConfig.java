/**
 * pajk.com Inc.
 * Copyright (c) 2014-2014 All Rights Reserved.
 */
package com.lvbby.user.config;

import com.alibaba.dubbo.config.spring.ServiceBean;
import com.lvbby.user.api.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by peng on 16/2/2.
 */
@Configuration
public class ExportServiceConfig {
    @Bean
    public ServiceBean userServiceExport(UserService userService) {
        return createService(userService,UserService.class);
    }

    public static ServiceBean createService(Object service, Class clz) {
        ServiceBean serviceBean = new ServiceBean();
        serviceBean.setProxy("javassist");
//        serviceBean.setVersion("0.1");
        serviceBean.setInterface(clz);
        serviceBean.setRef(service);
        serviceBean.setTimeout(5000);
        serviceBean.setRetries(3);
        return serviceBean;
    }

    public static ServiceBean createService(Object service) {
        Class<?>[] interfaces = service.getClass().getInterfaces();
        if (interfaces.length != 1)
            throw new RuntimeException(String.format("service [%s] has multi interfaces , please config dubbo service specifically", service.getClass().getSimpleName()));
        return createService(service, interfaces[0]);
    }
}
