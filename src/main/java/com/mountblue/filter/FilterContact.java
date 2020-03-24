package com.mountblue.filter;

import com.google.gson.Gson;
import com.mountblue.entity.ContactUsEntry;
import com.mountblue.entity.Response;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

import com.mountblue.api.FormSubmit;

import static com.mountblue.constant.Constant.*;

@WebFilter(value = "/FormSubmit")
public class FilterContact implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Response resp = new Response();
        StringBuffer string = new StringBuffer();
        String line;
        BufferedReader reader = request.getReader();
        while ((line = reader.readLine()) != null) {
            string.append(line);
        }
        Gson gson = new Gson();
        ContactUsEntry contactUsEntry = gson.fromJson(string.toString(), ContactUsEntry.class);
        contactUsEntry.setEmail(contactUsEntry.getEmail().toLowerCase());

        if (!contactUsEntry.getFname().equals(EMPTY) && !contactUsEntry.getLname().equals(EMPTY)
                && !contactUsEntry.getPhoneNumber().equals(EMPTY) && !contactUsEntry.getEmail().equals(EMPTY)
                && !contactUsEntry.getMessage().equals(EMPTY)
                && Pattern.matches(PHONE_PATTERN, contactUsEntry.getPhoneNumber())
                && Pattern.matches(EMAIL_PATTERN, contactUsEntry.getEmail())) {

            request.setAttribute(OBJECT, contactUsEntry);
            chain.doFilter(request, response);
        } else {
            resp.setStatus(FAILED);
            resp.setMessage(INVALID_MESSAGE);
            new FormSubmit().sendResponse(gson, (HttpServletResponse) response, resp);
        }

    }
}
