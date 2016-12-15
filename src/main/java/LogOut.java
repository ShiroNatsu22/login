import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Joshua on 20/11/2016.
 */

/**
 *Aquesta classe es l'encarregada de que l'usuari pugui tancar la seva sessio.
 */
public class LogOut extends HttpServlet {
    /**
     *
     * Aquest metode s'encarrega de invalidar la sessio actual.
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.invalidate();
        response.sendRedirect("index.jsp");
    }
}
