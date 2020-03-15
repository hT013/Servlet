package com.Insure;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.persistence.*;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(value = "/FormSubmit")
public class FormFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        if (Pattern.matches("\\w+@\\w+\\.\\w+", email) && !(request.getParameter("fname").equals("")) 
        && !(request.getParameter("lname").equals("")) && !(request.getParameter("message").equals("")) &&
         Pattern.matches("[0-9]{10}", phone)) {
            chain.doFilter(request, response);
        } else {
            request.setAttribute("invalid", "invalid");
        }
        request.getRequestDispatcher("contact-page.jsp").forward(request, response);
    }
    
    
}