package com.suray.wcsgui.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Charles on 2018/5/15.
 */
public class SpringUtils {
    private static ApplicationContext context;

    static {
        context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    /**
     * 根据名称通过Spring容器获取对象
     *
     * @param beanName 自定义bean名称
     * @return Object类型实例
     */
    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
