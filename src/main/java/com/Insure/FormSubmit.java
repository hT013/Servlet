package com.Insure;

import static com.Insure.Constant.*;

import java.io.BufferedReader;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(value = "/FormSubmit")
public class FormSubmit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {
        /*

        ContactForm contactForm = new ContactForm();
        contactForm.setFname(request.getParameter(FNAME));
        contactForm.setLname(request.getParameter(LNAME));
        contactForm.setPhoneNumber(request.getParameter(PHONE));
        contactForm.setEmail(request.getParameter(E_MAIL));
        contactForm.setMessage(request.getParameter(MESSAGE));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(contactForm);
        em.getTransaction().commit();

        em.close();
        emf.close();

        */
        StringBuffer string = new StringBuffer();
        String line = null;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            string.append(line);
        }
        Gson gson = new Gson();
        ContactForm contactForm = gson.fromJson(string.toString(), ContactForm.class);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(contactForm);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    

}