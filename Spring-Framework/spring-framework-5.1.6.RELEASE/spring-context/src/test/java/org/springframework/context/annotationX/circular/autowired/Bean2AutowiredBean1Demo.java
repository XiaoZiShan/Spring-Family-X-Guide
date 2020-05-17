package org.springframework.context.annotationX.circular.autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring  @Autowired DI  循环依赖  Bean2 Demo
 */
@Component
public class Bean2AutowiredBean1Demo {

    @Autowired
   private Bean1AutowiredBean2Demo bean1;

    public void hello(){
        System.out.println("Run Circular Dependency Success");
    }

}
