package com.mountblue.api;

import static com.mountblue.constant.Constant.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mountblue.entity.ContactUsEntry;
import com.mountblue.entity.Response;

@WebServlet(value = "/FormSubmit")
public class FormSubmit extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        Response resp = new Response();

        try {
            Gson gson = new Gson();
            ContactUsEntry contactUsEntry = (ContactUsEntry) request.getAttribute(OBJECT);
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_NAME);
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(contactUsEntry);
            em.getTransaction().commit();

            resp.setStatus(SUCCESS);
            resp.setMessage(SUCCESS_MESSAGE);
            sendResponse(gson, response, resp);
        } catch (Exception e) {
            resp.setStatus(FAILED);
            resp.setMessage(FAILED_MESSAGE);
            sendResponse(new Gson(), response, resp);
        }

    }

    public void sendResponse(Gson gson, HttpServletResponse response, Response resp) {
        PrintWriter out;
        try {
            out = response.getWriter();
            response.setContentType(CONTENT_TYPE);
            response.setCharacterEncoding(UTF_8);
            out.println(gson.toJson(resp));
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}