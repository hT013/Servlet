package com.Insure;

import java.io.IOException;

import static com.Insure.Constant.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/SignUp")
public class SignUp extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        Credential credential = new Credential();
        credential.setUserName(request.getParameter(UNAME));
        credential.setEmail(request.getParameter(E_MAIL));
        credential.setPassword(request.getParameter(PASSWORD));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(credential);
        em.getTransaction().commit();
        response.sendRedirect(LOGIN);

        em.close();
        emf.close();
    }

}