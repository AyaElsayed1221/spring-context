package com.example.demo1.execute;

import com.example.demo1.beans.MyBean;
import com.example.demo1.beans.SecondBean;
import com.example.demo1.config.ProjectConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Demo1Application {

	public static void main(String[] args) {

		/**
		 * The AnnotationConfigApplicationContext is a class that implements the ApplicationContext interface, ad this context has to be cnfigured somewhere
		 * The context in Spring framework can be configured by either  <B>XML files</B>, or  <B>Annotations</B>
		 * and this configuration is passed as an argument to the ApplicationContext
		 * here i make a class called ProjectConfig to make inside it the configuration of the context
		 * this configuration class will be annotated using the annottion that is called @Configuration.
		 * this annotaton is what tell Spring that this is a configuration class
		 * You can have multiple configuration classes
		 * and you can import one configuration to another
		 * You can even have both XML and annotation configuration at the same time.
		 **/

		AnnotationConfigApplicationContext context =
					 new AnnotationConfigApplicationContext(ProjectConfig.class);


		/**
		 *Lets get further and see what is the first possibility of creating a bean.
		 *
		 * What is a Bean: a bean is a class with instances will be placed in the application Context
		 *
		 * There are multiple ways to create a Bean, but i will mention only two ways of them:
		 *
		 * 	The first way of creating a Bean:
		 * 			1. Create a normal class as i did in MyBean.java
		 * 			2. Go to the configuration class of the context which is the ProjectConfig.java here and create a method  that
		 * 				will return an instance of the bean (MyBean.java)
		 *				3. add the @Bean annotation above the method. after add this annotation the return instance will be stored inside
		 *					the Context
		 *
		 * Note: Usually the name of the method is an action or verb, but in this case it willbe usually the name of the bean itself
		 **/

			MyBean b1 = context.getBean(MyBean.class);
		System.out.println(b1.getName());

		//if u try to retrieve a bean not exist in th context an exception called NoSuchBeanDefinitionException will be thrown.
		//if u take from the context multiple beans like b1, b2, b3 all of them will be the same instance where the
		//scopes of Beans in spring context are two scopes Singlton and Prototype ans the Siglton is the default scope
		//and this is why b1,b1, and b3 are actually the same instance.
		MyBean b2 = context.getBean(MyBean.class);
		System.out.println(b2.getName());

		MyBean b3 = context.getBean( MyBean.class);
		System.out.println(b3.getName());



		//Now, We have a question, What happens if we have two beans of the same class inside the context?
		//Ans: we will get an exception, bec we by this telling the spring to get us an instance of a specific type of bean,
		// but spring will see now muliple instaces with the same type so there will be a confusion to which instance will be retrieved.

		// We can solve this problem by two ways:
		//make a bean of them a primary bean, which will be returned in case of cofusion, by adding @Primary annottion above the function of the bean
		//the second way is to pass the name of the bean (name of the function) as a parameter to the getBean method to tel spring which bean u want

		MyBean b4 = context.getBean( "myBean2",MyBean.class);
		System.out.println(b4.getName());

		/*************************************************************************************************************/

		//The second way of creating a bean is by using the Stereotype

		/**
		 * Stereotype annotation: Are a set of specialized annotations that are used the role or purpose of a particular componentwithin the appliaction.
		 										 ex: Service, Repository, Component
		 * The stereotype annotation is used to specify that we wnt an instance of specific class in the context of the spring.
		 **/

		//Just by placing @Component above the class, i tell the spring that i want an instance of this class as a bean in the context. But this is is NOT ENOUGH
		//if i run it as it it will throw mw an exception that is NoSuchBeanDefinitionException
		//and the reason for that is that the Spring by default doesn't scan for components.

		//So what ese should i do?
		//in the configuraion class, i should go again and add above it anothe annotation that is called @ComponentScan(basePackage = " ") and
		// give it the name of the package where the spring should search for a component there.


		//Note that the bean that created by ths way is not initialized, if you want to initialize it you can write an initialization method inside the bean class
		// and add above it annotation called @PostConstruct

		//var applicationContext = new AnnotationConfigApplicationContext(ProjectConfig.class);

		SecondBean secondBean = context.getBean("secondBean",SecondBean.class);
		System.out.println(secondBean.getName());
		// here there is an error i don't know why?!

		/*********************************************************************************************/
		//Autowiring

	}

}
