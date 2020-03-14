package com.Insure;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/SignIn")
public class SignIn extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Credential credential = new Credential();
        credential.setUserName(request.getParameter("uname"));
        credential.setEmail(request.getParameter("email"));
        credential.setPassword(request.getParameter("password"));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Form");
        EntityManager em = emf.createEntityManager();

        if(em.find(Credential.class, credential.getEmail()) == null) {
            em.getTransaction().begin();
            em.persist(credential);
            em.getTransaction().commit();
            response.sendRedirect("login.jsp");
        } else {
            //Already contains email in database
        }

        em.close();
        emf.close();
    }

}