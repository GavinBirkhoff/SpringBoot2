package com.gavin.boot;

import ch.qos.logback.core.db.DBHelper;
import com.gavin.boot.bean.Pet;
import com.gavin.boot.bean.User;
import com.gavin.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * 主程序类
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@SpringBootApplication  //相当以下三个注解
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.gavin.boot") // 包扫描
public class MainApplication {
    public static void main(String[] args) {
        // 返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 查看容器组价
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("name = " + name);
        }

        // 从容器中取组件验证是否单例
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件" + (tom01 == tom02));

        // com.gavin.boot.config.MyConfig$$EnhancerBySpringCGLIB$$6b0d49ed@1422ac7f
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中有。
        //保持组件单实例
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println(user == user1);

        // @Configuration(proxyBeanMethods = true) 宠物是容器中的组件
        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("My pet " + (user01.getPet()==tom));

        // 获取组件
        String[] beanNames = run.getBeanNamesForType(User.class);
        for (String name : beanNames){
            System.out.println("name = " + name);
        }
        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);

        boolean person = run.containsBean("person");
        boolean animal = run.containsBean("animal");
        System.out.println("person = " + person);
        System.out.println("animal = " + animal);

    }
}
