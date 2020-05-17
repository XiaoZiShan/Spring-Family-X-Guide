package org.springframework.context.annotationX.circular.constructor;


import org.springframework.stereotype.Component;

/**
 * Spring Constructor DI 循环依赖  Bean1 Demo
 */
@Component
public class Bean1ConstructorBean2Demo {

   private Bean2ConstructorBean1Demo bean2;

    public Bean1ConstructorBean2Demo(Bean2ConstructorBean1Demo bean2DependBean1Demo) {
        this.bean2 = bean2DependBean1Demo;
    }

    public void hello() {
        bean2.hello();
    }
}
