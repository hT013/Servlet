package com.Insure;

import java.io.IOException;
import java.util.regex.Pattern;

import static com.Insure.Constant.*;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(value = "/FormSubmit")
public class FormFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        String email = request.getParameter(E_MAIL);
        String phone = request.getParameter(PHONE);

        if (Pattern.matches(EMAIL_PATTERN, email) && !(request.getParameter(FNAME).equals(EMPTY)) 
        && !(request.getParameter(LNAME).equals(EMPTY)) && !(request.getParameter(MESSAGE).equals(EMPTY)) &&
         Pattern.matches(PHONE_PATTERN, phone)) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute(INVALID, INVALID);
        }
        request.getRequestDispatcher(CONTACT_PAGE).forward(request, response);
    }
    
    
}