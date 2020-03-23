package com.mountblue.web;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mountblue.entity.ContactUsEntry;
import com.mountblue.entity.Users;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import static com.mountblue.constant.Constant.*;
import static com.mountblue.constant.Constant.SIGN_IN;

@WebServlet(urlPatterns = {"/auth/signup", "/auth/signin", "/auth/signout"})
public class Authentication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String path = request.getServletPath();
        final String SIGN_IN_SERVLET = "/auth/signin";
        final String SIGN_UP_SERVLET = "/auth/signup";
        final String SIGN_OUT_SERVLET = "/auth/signout";

        switch (path) {
            case SIGN_IN_SERVLET:
                signIn(request, response);
                break;
            case SIGN_UP_SERVLET:
                signUp(request, response);
                break;
            case SIGN_OUT_SERVLET:
                signOut(request, response);
                break;
        }

    }

    private void signOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.removeAttribute(E_MAIL);
        session.removeAttribute(USER);
        session.removeAttribute(CONTACT_FORM);
        session.invalidate();
        response.sendRedirect(SIGN_IN);
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Users users = new Users();
        users.setUserName(request.getParameter(UNAME));
        users.setEmail(request.getParameter(E_MAIL));
        users.setPassword(BCrypt.withDefaults().hashToString(12, request.getParameter(PASSWORD).toCharArray()));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(users);
        em.getTransaction().commit();
        response.sendRedirect(SIGN_IN);

        em.close();
        emf.close();
    }

    private void signIn(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String email = request.getParameter(E_MAIL);
        String password = request.getParameter(PASSWORD);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();
        HttpSession session = request.getSession();

        Users users = em.find(Users.class, email);
        if (users != null && users.getPassword() != null && BCrypt.verifyer().verify(password.toCharArray(),
                users.getPassword()).verified) {

            session.setAttribute(USER, users.getUserName());
            session.setAttribute(E_MAIL, email);
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ContactUsEntry> cq = cb.createQuery(ContactUsEntry.class);
            Root<ContactUsEntry> root = cq.from(ContactUsEntry.class);
            CriteriaQuery<ContactUsEntry> select = cq.select(root);
            TypedQuery query = em.createQuery(select);

            List<ContactUsEntry> list = query.getResultList();
            em.getTransaction().commit();

            session.setAttribute(CONTACT_FORM, list);
            response.sendRedirect(SHOW_DATA);
        } else {
            session.setAttribute(EXIST, EXIST);
            response.sendRedirect(SIGN_IN);
        }
    }

}
