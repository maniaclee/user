package com.lvbby.user.config;

import com.alibaba.dubbo.config.spring.ServiceBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

/**
 * Created by lipeng on 16/8/4.
 */

//@Component
public class RpcRegisterProcessor implements BeanPostProcessor, ApplicationContextAware {
    ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Service.class)) {
            ServiceBean service = ExportServiceConfig.createService(bean);
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(service.getClass());
            String serviceName = beanName + "Export";
            beanDefinitionBuilder.addPropertyValue("servicename", serviceName);
            System.out.println("--------------- register-bean -----------" + serviceName);
            registerBean(serviceName, beanDefinitionBuilder.getRawBeanDefinition(), (ConfigurableApplicationContext) applicationContext);
        }
        return bean;
    }

    private void registerBean(String beanName, BeanDefinition beanDefinition, ConfigurableApplicationContext context) {
        ConfigurableApplicationContext configurableApplicationContext = context;
        BeanDefinitionRegistry beanDefinitonRegistry = (BeanDefinitionRegistry) configurableApplicationContext
                .getBeanFactory();
        beanDefinitonRegistry.registerBeanDefinition(beanName, beanDefinition);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
