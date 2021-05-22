package com.spring.demo.prototypeBeanDestructionProcessor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * For Managing the life-cycle of Prototype Beans, we need to follow these steps:
 * 1. Create a Custom Bean Processor, which can filter out Prototype Beans & keep them,
 * so as to call Life-cycle(Destruction) Methods on those Prototype Beans.
 * 
 * 2. This Custom Bean Processor must be registered in the Container/Relevant ApplicationContext
 * which holds the Prototype Beans to be managed by this Custom Bean Post Processor.
 * <!-- Bean custom processor to handle calling destroy methods on prototype scoped beans -->
    <bean id="customProcessor"
    		class="com.spring.demo.prototypeBeanDestructionProcessor.MyPrototypeBeanProcessor">
   	</bean>
 * 
 * 3. The Prototype Beans whose Destruction is to be handled by this Custom Bean Post
 * Processor need to implement DisposableBean Interface.
 * 
 * @author Dhirendra
 */
public class MyPrototypeBeanProcessor implements DisposableBean, BeanPostProcessor, BeanFactoryAware {
	
	private BeanFactory beanFactory;
	
	private final List<Object> prototypeBeans = new ArrayList<>();
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		//After Startup, keep track of Prototype Beans:
		//We will need to know who they are for destruction later:
		if (beanFactory.isPrototype(beanName)) {
			synchronized(prototypeBeans) {
				prototypeBeans.add(bean);
			}
			
		}
		
		return bean;
	}
	
	@Override
	public void destroy() throws Exception {
		//Loop through the Prototype Beans & call Destroy method on each one:
		synchronized (prototypeBeans) {
			prototypeBeans.stream().forEach(prototypeBean -> {
				if (prototypeBean instanceof DisposableBean) {
					DisposableBean disposablePrototypeBean = (DisposableBean) prototypeBean;
					
					try {
						disposablePrototypeBean.destroy();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
			prototypeBeans.clear();
		}
	}

}
