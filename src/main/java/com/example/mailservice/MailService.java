package com.example.mailservice;

import java.io.*;
import java.util.Properties;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(urlPatterns = {"/mail-servlet"},
        initParams = { @WebInitParam(name = "mail", value = "veles.mk.12@gmail.com"),
                        @WebInitParam(name ="mail.smtps.host", value = "smtp.gmail.com"),
                        @WebInitParam(name = "mail.smtp.port", value = "465"),
                        @WebInitParam(name = "smtps.auth.user", value = "markouskiehustudy@gmail.com"),
                        @WebInitParam(name = "smtps.auth.pass", value = "batmczxnrlszdhrn"),
                        @WebInitParam(name = "mail.transport.protocol", value = "smtps") })
public class MailService extends HttpServlet {
    final static Logger log = LogManager.getLogger(MailService.class);
//    String mail = null;
    public void init() {
//        ServletConfig config = this.getServletConfig();
//        mail = config.getInitParameter("mail");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        log.debug("Start method doPost");
        Properties properties = new Properties();
        ServletContext context = getServletContext();//
        ServletConfig config = this.getServletConfig();//

        properties.load(context.getResourceAsStream("/WEB-INF/mail.properties"));

        MailThread mailThread = new MailThread(
                request.getParameter("to"),
                request.getParameter("subject"),
                request.getParameter("body"),
                properties);

        mailThread.start();
        log.debug("start mailThread");
        request.getRequestDispatcher("/jsp/sending.jsp").forward(request, response);

    }

    public void destroy() {
    }
}