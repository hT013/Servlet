package com.Insure;

import java.io.IOException;

import static com.Insure.Constant.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(value = "/LogOut")
public class LogOut extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        HttpSession session = request.getSession();
        session.removeAttribute(E_MAIL);
        session.removeAttribute(USER);
        session.invalidate();
        response.sendRedirect(LOGIN);
    }

}