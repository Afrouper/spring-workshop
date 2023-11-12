package de.repmek.springworkshop.rest;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class HelloServlet extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        if(name != null) {
            name = "Hello " + name;
            LOGGER.debug("Reply {} as response.", name);

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
            resp.setContentType("text/plain");
            resp.setContentLength(name.length());
            resp.getWriter().print(name);
        }
        else {
            LOGGER.error("Unable to serve request. Reply error");
            String error = "Query parameter name missing";

            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
            resp.setContentType("text/plain");
            resp.setContentLength(error.length());
            resp.getWriter().print(error);
        }
    }
}
