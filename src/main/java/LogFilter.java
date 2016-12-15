/**
 * Created by Joshua on 20/11/2016.
 * @author Pablo i Joshua
 * @version 1.0.0
 */
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class

/**
 * Aquesta classe s'encarregara de fer el redireccionament a l'index
 */
public class LogFilter implements Filter  {

    /**
     * @param config
     * @throws ServletException
     *
     */
    public void  init(FilterConfig config)
            throws ServletException{
        // Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    /**
     * Aquest filtre serveix per a que, si no estas logat, te redireccioni al index si es aixi.
     * @param request
     * @param response
     * @param chain
     * @throws java.io.IOException
     * @throws ServletException
     */
    public void  doFilter(ServletRequest request,
                          ServletResponse response,
                          FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpSession session = ((HttpServletRequest)request).getSession();

        if(session.getAttribute("email")==null){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("index.jsp");



        } else {

            // Pass request back down the filter chain
            chain.doFilter(request,response);
        }


    }

    /**
     * Aquest metode ha d'estar obligatoriament, pero no fa res
     */
    public void destroy( ){
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
