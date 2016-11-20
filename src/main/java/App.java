import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");

        List<Users> listuser = (List<Users>) context.getBean("list");

        for (Users u : listuser){
            System.out.println("Nombre: " + u.getName() + " Pass: " + u.getPass() + " Email: " + u.getEmail());

        }
    }
}
