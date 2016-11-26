import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Joshua on 20/11/2016.
 */
public class RedirectFile implements Filter {
    public void  init(FilterConfig config)
            throws ServletException {
        // Get init parameter
        String testParam = config.getInitParameter("redirect-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }
    public void  doFilter(ServletRequest request,
                          ServletResponse response,
                          FilterChain chain)
            throws java.io.IOException, ServletException {

        HttpSession session = ((HttpServletRequest)request).getSession();

        if(session.getAttribute("email")!=null){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect("fileUpload.jsp");

        }else {

            // Pass request back down the filter chain
            chain.doFilter(request,response);
        }


    }
    public void destroy( ){
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
