/**
 * Created by Joshua on 20/11/2016.
 */
// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

// Implements Filter class
public class LogFilter implements Filter  {
    public void  init(FilterConfig config)
            throws ServletException{
        // Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }
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
    public void destroy( ){
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
