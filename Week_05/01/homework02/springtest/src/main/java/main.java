
import anotation.Student01;
import javaconfig.Config;
import javaconfig.HelloSpring02;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xmlconfig.HelloSpring;

public class main {
    public static void main(String[] args)
    {
        //使用注解+包扫描方式
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Student01 s = (Student01) context.getBean("student01");
        s.sayHello();

        //使用xml配置
        HelloSpring helloSpring = (HelloSpring) context.getBean("HelloSpring");
        helloSpring.sayHello();

        // 使用bean
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(Config.class);
        HelloSpring02 helloSpring02 = (HelloSpring02) applicationContext.getBean("helloSpring");
        helloSpring02.sayHello();
    }
}
