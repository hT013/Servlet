package com.Insure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/FormSubmit")
public class FormSubmit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException {
        ContactForm contactForm = new ContactForm();
        contactForm.setFname(request.getParameter("fname"));
        contactForm.setLname(request.getParameter("lname"));
        contactForm.setPhoneNumber(request.getParameter("phone"));
        contactForm.setEmail(request.getParameter("email"));
        contactForm.setMessage(request.getParameter("message"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Form");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(contactForm);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

}