package com.Insure;

import java.io.IOException;
import java.util.regex.Pattern;

import static com.Insure.Constant.*;

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
        String email = request.getParameter(E_MAIL);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();

        Credential credential = em.find(Credential.class, email);

        if (Pattern.matches(EMAIL_PATTERN, email) && !(request.getParameter(UNAME).equals(EMPTY)) 
        && !(request.getParameter(PASSWORD).equals(EMPTY)) && credential == null) {
            chain.doFilter(request, response);
        } else if (credential != null) {
            request.setAttribute(EXIST, EXIST);
            request.getRequestDispatcher(SIGNUP).forward(request, response);
        } else {
            request.setAttribute(INVALID, INVALID);
            request.getRequestDispatcher(SIGNUP).forward(request, response);
        }
    }
    
    
}