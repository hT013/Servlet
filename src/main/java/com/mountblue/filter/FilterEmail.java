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

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String email = request.getParameter(E_MAIL).toLowerCase();
        String user = request.getParameter(U_NAME);
        String password = request.getParameter(PASSWORD);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();

        Users users = em.find(Users.class, email);
        HttpSession session = ((HttpServletRequest) request).getSession();

        if (Pattern.matches(EMAIL_PATTERN, email) && users == null && !password.equals(EMPTY)
                && !user.equals(EMPTY)) {
            chain.doFilter(request, response);
        } else {
            session.setAttribute(TEMP_E_MAIL, email);
            session.setAttribute(TEMP_UNAME, user);
            if (users != null) {
                session.setAttribute(EXIST, EXIST);
            } else {
                session.setAttribute(INVALID, INVALID);
            }
            ((HttpServletResponse) response).sendRedirect(SIGN_UP);
        }
    }


}