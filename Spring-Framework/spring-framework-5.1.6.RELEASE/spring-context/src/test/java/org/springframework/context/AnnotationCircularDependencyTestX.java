package org.springframework.context;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotationX.circular.autowired.Bean1AutowiredBean2Demo;
import org.springframework.context.annotationX.circular.constructor.Bean1ConstructorBean2Demo;

/**
 * Created by 刷题使我快乐,自律使我自由 !
 */
public class AnnotationCircularDependencyTestX {

	@Test
	public void diBeanByAutowired() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.context.annotationX.circular.autowired");
		context.refresh();
		Bean1AutowiredBean2Demo bean1 = (Bean1AutowiredBean2Demo) context.getBean("bean1AutowiredBean2Demo");
		bean1.hello();
	}

	@Test
	public void diBeanByConstructor () throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.context.annotationX.circular.constructor");
		context.refresh();
		Bean1ConstructorBean2Demo bean1 = (Bean1ConstructorBean2Demo) context.getBean("bean1ConstructorBean2Demo");
		bean1.hello();
	}

}