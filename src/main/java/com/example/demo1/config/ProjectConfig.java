package com.example.demo1.config;

import com.example.demo1.beans.MyBean;
import com.example.demo1.beans.SecondBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/**
 * This class is the configuration of the context
 **/
@Configuration
@ComponentScan(basePackages = "beans")
public class ProjectConfig {

@Primary
@Bean
MyBean myBean1(){
    MyBean bean = new MyBean();
    bean.setName("Ayaa");
    return bean;
}

    @Bean
    MyBean myBean2(){
        MyBean bean = new MyBean();
        bean.setName("catyy");
        return bean;
    }

}
