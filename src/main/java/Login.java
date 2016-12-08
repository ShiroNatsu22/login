import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import java.util.List;


/**
 * Created by Joshua on 20/11/2016.
 */
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-conf.xml");

        List<Users> userList = (List) context.getBean("list");


        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String check = request.getParameter("check");
        HttpSession session = request.getSession();

        for (Users u : userList) {

            if (email.equals(u.getEmail()) && pass.equals(u.getPass())) {

                session.setAttribute("email", email);
                session.setAttribute("name", u.getName());

                if(check != null){
                    if (check.equals("cookie") ){
                        Cookie cookie = new Cookie("email", u.getEmail());
                        cookie.setMaxAge(60 * 60 * 168);
                        response.addCookie(cookie);
                    }
                }
                String carpeta = email.split("@")[0];
                session.setAttribute("carpeta", carpeta);
                File directorio = new File("C:/xampp/tomcat/webapps/data/" +carpeta + "/");
                if(!directorio.exists()) {
                    directorio.mkdir();
                }


                File directory = new File(getServletContext().getInitParameter("file-upload") + carpeta);
                directory.mkdir();
                String strPath = getServletContext().getInitParameter("file-upload") + carpeta;
                File strFile = new File(strPath + "\\RegistreUsuari.log");

                String logContent = "<p>Dia: " + new Date() + " User: " + u.getName() + " IP: " + request.getRemoteAddr() +"</p>" ;
                BufferedWriter outStream = new BufferedWriter(new FileWriter(strFile, true));
                outStream.newLine();
                outStream.write(logContent);
                outStream.close();
                strPath = getServletContext().getInitParameter("file-upload");
                strFile = new File(strPath + "Registre.log");
                logContent = "<p>Dia: " + new Date() + " Usuari: " + u.getName() + " IP: " + request.getRemoteAddr() + "</p>";
                outStream = new BufferedWriter(new FileWriter(strFile, true));
                outStream.newLine();
                outStream.write(logContent);
                outStream.close();
                response.sendRedirect("fileUpload.jsp");


                return;
            }
        }
        String errorMessage = "Datos invalidos,introduce datos validos POH FABOH";
        session.setAttribute("error", errorMessage);
        response.sendRedirect("index.jsp");


    }


}
