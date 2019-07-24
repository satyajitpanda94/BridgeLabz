package com.bridgelabz.Demoq;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
    	Vehicle obj=(Vehicle) context.getBean("bike");
    	obj.run();
    	((ClassPathXmlApplicationContext)context).close();
    }
}
