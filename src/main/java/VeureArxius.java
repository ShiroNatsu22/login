import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * Created by Joshua on 26/11/2016.
 * @author Pablo i Joshua
 * @version 1.0.0
 */

/**
 * Aquesta classe s'encarrega de mostrar a l'usuari els fitxers que hi ha al seu directori :), a més d'esborrar el fitxers
 * que no vulgui l'usuari ;P
 */
public class VeureArxius extends HttpServlet{
    /**
     * Aquest metode permetra veure els arxius que l'usuari a pujat, i permetra també esborrarlos
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        java.io.PrintWriter out = response.getWriter( );
        HttpSession session = request.getSession();
        String path = getServletContext().getInitParameter("file-upload")  + session.getAttribute("carpeta") + "/";
        File f = new File(path);
        response.setIntHeader("Refresh", 5);

        File[] ficheros = f.listFiles();
        for (int x=0;x<ficheros.length;x++){
            out.println("<p>Nombre --> " + ficheros[x].getName() );
            out.println("<a href='VeureArxius?esborra="+ x +"'/>esborra </a></p>");

        }
        out.println("<button type='button' onclick='window.location.href=\"fileUpload.jsp\"'>Torna Enrere</button>");

        if (ficheros != null) {
            for (int i = 0; i < ficheros.length; i++) {
                if (request.getParameterMap().containsKey("esborra")) {
                    if (Integer.parseInt(request.getParameter("esborra")) == i) {
                        ficheros[i].delete();
                        response.sendRedirect("VeureArxius");
                        break;
                    }
                }


            }
        }


    }
}
