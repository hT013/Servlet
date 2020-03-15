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

@WebFilter(value = "/SignUp")
public class FilterEmail implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
        String email = request.getParameter("email");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Form");
        EntityManager em = emf.createEntityManager();

        if (Pattern.matches("\\w+@\\w+\\.\\w+", email) && !(request.getParameter("uname").equals("")) 
        && !(request.getParameter("password").equals(""))) {
            chain.doFilter(request, response);
        } else if (em.find(Credential.class, email) != null) {
            request.setAttribute("exist", "exist");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            request.setAttribute("invalid", "invalid");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }
    
    
}