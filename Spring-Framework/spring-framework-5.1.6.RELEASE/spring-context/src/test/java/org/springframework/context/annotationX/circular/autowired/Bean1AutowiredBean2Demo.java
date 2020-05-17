package org.springframework.context.annotationX.circular.autowired;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Spring  @Autowired DI 循环依赖  Bean1 Demo
 */
@Component
public class Bean1AutowiredBean2Demo {

   @Autowired
   private Bean2AutowiredBean1Demo bean2;

    public void hello() {
        bean2.hello();
    }
}
