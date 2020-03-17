package com.Insure;

import java.io.IOException;
import java.util.*;
import at.favre.lib.crypto.bcrypt.BCrypt;

import static com.Insure.Constant.*;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/LogIn")
public class LogIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IllegalArgumentException, IOException, ServletException{
        String email = request.getParameter(E_MAIL);
        String password = request.getParameter(PASSWORD);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();
        HttpSession session = request.getSession();

        Credential credential = em.find(Credential.class, email);
        if (credential != null  && credential.getPassword() != null && BCrypt.verifyer().verify(password.toCharArray(),credential.getPassword()).verified){

            session.setAttribute(USER, credential.getUserName());
            session.setAttribute(E_MAIL, email);
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ContactForm>  cq = cb.createQuery(ContactForm.class);
            Root<ContactForm> root = cq.from(ContactForm.class);
            CriteriaQuery<ContactForm> select = cq.select(root);
            TypedQuery query = em.createQuery(select);

            List<ContactForm> list = query.getResultList();
            em.getTransaction().commit();

            session.setAttribute(CONTACT_FORM, list);
            response.sendRedirect(SHOW_DATA);
        } else {
            request.setAttribute(EXIST, EXIST);
            request.getRequestDispatcher(LOGIN).forward(request, response);
        }
    }

}