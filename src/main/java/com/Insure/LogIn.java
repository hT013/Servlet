package com.Insure;

import java.io.IOException;
import java.util.*;

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
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Form");
        EntityManager em = emf.createEntityManager();
        HttpSession session = request.getSession();

        Credential credential = em.find(Credential.class, email);
        if (credential != null  && credential.getPassword() != null && credential.getPassword().equals(password)) {
            session.setAttribute("user", credential.getUserName());
            session.setAttribute("email", email);
            em.getTransaction().begin();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<ContactForm>  cq = cb.createQuery(ContactForm.class);
            Root<ContactForm> root = cq.from(ContactForm.class);
            CriteriaQuery<ContactForm> select = cq.select(root);
            TypedQuery query = em.createQuery(select);
            List<ContactForm> list = query.getResultList();
            em.getTransaction().commit();
            session.setAttribute("contactform", list);
            request.getRequestDispatcher("show-data.jsp").forward(request, response);
        } else {
            request.setAttribute("exist", "exist");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}