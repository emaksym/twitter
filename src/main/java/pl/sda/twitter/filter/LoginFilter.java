package pl.sda.twitter.filter;

import pl.sda.twitter.constans.SessionValues;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;

@WebFilter(urlPatterns = "/add-article.jsp")
public class LoginFilter implements Filter {

    final String userValue = SessionValues.USER.getValue();


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpRequest =  (HttpServletRequest) request ;
        final Object user = httpRequest.getSession().getAttribute(userValue);
        final String messagesValue= SessionValues.MESSAGES.getValue();

        if (user==null){
            final HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpRequest.getSession().setAttribute(messagesValue, Collections.singletonList("Zaloguj się by kontynuować"));
            httpResponse.sendRedirect("login.jsp");
        }

        filterChain.doFilter(request, response);

    }
}
