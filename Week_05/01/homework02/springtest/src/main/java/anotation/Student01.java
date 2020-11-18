package anotation;


import org.springframework.stereotype.Component;

@Component("student01")
public class Student01 {

    public void sayHello() {
        System.out.println("Hello student01");
    }

}
