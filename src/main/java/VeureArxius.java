import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Joshua on 26/11/2016.
 */
public class VeureArxius extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        java.io.PrintWriter out = response.getWriter( );
        HttpSession session = request.getSession();
        String path = getServletContext().getInitParameter("file-upload") + session.getAttribute("carpeta") + "\\";
        File f = new File(path);
        response.setIntHeader("Refresh", 5);

        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++){
            out.println("<p>Nombre --> " + ficheros[x].getName() + "</p>");
        }

    }
}
