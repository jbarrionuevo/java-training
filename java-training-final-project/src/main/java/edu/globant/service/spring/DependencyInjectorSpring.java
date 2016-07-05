package edu.globant.service.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public interface DependencyInjectorSpring{
	
	public default BeanFactory getSpringBeanFactory() {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/beans.xml");
		BeanFactory factory = context;
		return factory;
	}
}
