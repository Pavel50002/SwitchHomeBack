package application.controller;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
//public class SimpleCORSFilter implements Filter {
public class SimpleCORSFilter extends OncePerRequestFilter {

    /* public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
         HttpServletResponse response = (HttpServletResponse) res;
         response.setHeader("Access-Control-Allow-Origin", "*");
         response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
         response.setHeader("Access-Control-Max-Age", "3600");
         response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
         chain.doFilter(req, res);
     }

     public void init(FilterConfig filterConfig) {}

     public void destroy() {}*/
    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers, Authorization");
        response.addHeader("Access-Control-Expose-Headers", "Access-Control-Allow-Origin, Access-Control-Allow-Credentials");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addIntHeader("Access-Control-Max-Age", 10);
        filterChain.doFilter(request, response);
    }

}