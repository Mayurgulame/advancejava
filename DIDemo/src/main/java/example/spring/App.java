package example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Fetch singleton scoped bean multiple times
        Human singletonHuman1 = (Human) context.getBean("singletonHuman");
        Human singletonHuman2 = (Human) context.getBean("singletonHuman");

        // Fetch prototype scoped bean multiple times
        Human prototypeHuman1 = (Human) context.getBean("prototypeHuman");
        Human prototypeHuman2 = (Human) context.getBean("prototypeHuman");

        // Check if the same instance is returned
        System.out.println("singletonHuman1 and singletonHuman2 are same instance: " + (singletonHuman1 == singletonHuman2));
        System.out.println("prototypeHuman1 and prototypeHuman2 are same instance: " + (prototypeHuman1 == prototypeHuman2));

        // Check if beans work correctly
        singletonHuman1.pumping();
        prototypeHuman1.pumping();
    }
}
