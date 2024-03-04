package homework.homework23;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;
import java.util.Date;

@WebFilter(urlPatterns = {"/book","/load-book"})
public class Filter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Date requestTime = new Date();
        System.out.println(requestTime + " - doFilter");
        chain.doFilter(request, response);
        Date responseTime = new Date();
        System.out.println(responseTime + " - doFilter - end");
    }

}
