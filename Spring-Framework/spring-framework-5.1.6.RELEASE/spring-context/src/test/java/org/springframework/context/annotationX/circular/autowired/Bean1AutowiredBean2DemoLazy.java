package org.springframework.context.annotationX.circular.autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * Spring  @Autowired DI 循环依赖  Bean1 Demo
 */
@Component
@Lazy
public class Bean1AutowiredBean2DemoLazy {
	
}
