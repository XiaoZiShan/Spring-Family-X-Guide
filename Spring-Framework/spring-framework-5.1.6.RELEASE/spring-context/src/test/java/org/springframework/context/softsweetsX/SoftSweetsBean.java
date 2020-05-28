package org.springframework.context.softsweetsX;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;

@Component
public class SoftSweetsBean implements InitializingBean, ApplicationContextAware {


	private String productionLineName;

	private String dateManufacture;


	public String getProductionLineName() {
		return productionLineName;
	}

	public String getDateManufacture() {
		return dateManufacture;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.dateManufacture = Instant.now().atZone(ZoneId.systemDefault()).toString();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		 this.productionLineName = applicationContext.getDisplayName();
	}
}
