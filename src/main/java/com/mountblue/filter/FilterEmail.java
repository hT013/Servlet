package com.mountblue.filter;

import com.mountblue.entity.Users;

import java.io.IOException;
import java.util.regex.Pattern;

import static com.mountblue.constant.Constant.*;

import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(value = "/auth/signup")
public class FilterEmail implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String email = request.getParameter(E_MAIL);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();

        Users users = em.find(Users.class, email);
        HttpSession session = ((HttpServletRequest) request).getSession();

        if (Pattern.matches(EMAIL_PATTERN, email) && !(request.getParameter(UNAME).equals(EMPTY))
                && !(request.getParameter(PASSWORD).equals(EMPTY)) && users == null) {
            chain.doFilter(request, response);
        } else if (users != null) {
            session.setAttribute(EXIST, EXIST);
            ((HttpServletResponse) response).sendRedirect(SIGN_UP);
        } else {
            session.setAttribute(INVALID, INVALID);
            ((HttpServletResponse) response).sendRedirect(SIGN_UP);
        }
    }


}