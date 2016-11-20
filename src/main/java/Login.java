import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by Joshua on 20/11/2016.
 */
public class Login extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, java.io.IOException{

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");

        List<Users> userList = (List)context.getBean("list");


        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        HttpSession session = request.getSession();

        for (Users u : userList){
            if(email.equals(u.getEmail()) && pass.equals(u.getPass())){



                session.setAttribute("email",email);
                session.setAttribute("name",u.getName());
                response.sendRedirect("fileUpload.jsp");

                return;
            }
        }
        String errorMessage ="Datos invalidos, y ya esta joputa hahaha";
        session.setAttribute("mensajeError", errorMessage);
        response.sendRedirect("index.jsp");



    }


}
