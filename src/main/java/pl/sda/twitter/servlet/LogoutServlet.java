package pl.sda.twitter.servlet;

import pl.sda.twitter.constans.SessionValues;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;


@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
   private final String messages = SessionValues.MESSAGES.getValue();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        session = req.getSession(true);
        session.setAttribute("messages", Collections.singletonList("Zostałeś wylogowany"));
        resp.sendRedirect("index.jsp");
    }
}
