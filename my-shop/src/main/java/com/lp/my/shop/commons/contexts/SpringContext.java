package com.lp.my.shop.commons.contexts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringContext {
    public Object getBean(String beanId) {
        ApplicationContext  context = new ClassPathXmlApplicationContext("spring-context.xml");
        return context.getBean(beanId);
    }
}