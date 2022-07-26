package com.codegym.Filter;

import com.codegym.models.Account;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;
@WebFilter("/blogs")
public class Loggin implements Filter {
    static public Account account;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (account == null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/Loggin.html");
            requestDispatcher.forward(request,response);
        }else {
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
