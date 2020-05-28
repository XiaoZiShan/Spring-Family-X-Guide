package org.springframework.context.softsweetsX;


import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SoftSweetsTest {

	@Test
	public void A_ProductLine() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("org.springframework.context.softsweetsX");
		context.refresh();
		SoftSweetsBean bean = (SoftSweetsBean) context.getBean("softSweetsBean");
		System.out.println("\n新鲜出炉的A软糖 ~~~ \n 生产线名称: " + bean.getProductionLineName() + "\n 生产日期: " + bean.getDateManufacture());
	}

	@Test
	public void X_ProductLine() {
		// test-resources
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("org/springframework/beans/factory/xml/SoftSweetsX.xml");
		SoftSweetsBean bean = (SoftSweetsBean) context.getBean("softSweetsBean");
		System.out.println("\n新鲜出炉的X软糖 ~~~ \n 生产线名称: " + bean.getProductionLineName() + "\n 生产日期: " + bean.getDateManufacture());
	}

}