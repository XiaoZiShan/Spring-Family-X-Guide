package org.springframework.context.annotationX.circular;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotationX.circular.autowired.Bean1AutowiredBean2Demo;
import org.springframework.context.annotationX.circular.constructor.Bean1ConstructorBean2Demo;
import org.springframework.core.log.LogFormatUtils;

public class AnnotationCircularDependencyTestX {
	protected final Log logger = LogFactory.getLog(getClass());

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


	@Test
	public  void logLogFormatUtilsTest(){
		LogFormatUtils.formatValue("hello Spring日志缩减方法", true);

		LogFormatUtils.traceDebug(logger,traceOn ->{
			return "hello 函数式编程";
		});
	}

}