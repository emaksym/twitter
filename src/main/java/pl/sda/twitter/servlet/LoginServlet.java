package pl.sda.twitter.servlet;

import pl.sda.twitter.constans.SessionValues;
import pl.sda.twitter.exceptions.IncorrectLoginOrPasswordException;
import pl.sda.twitter.persistance.entities.TbUser;
import services.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    private final String user = SessionValues.USER.getValue();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        final HttpSession session = req.getSession();
        final String messages = SessionValues.MESSAGES.getValue();

        try {
            final TbUser tbUser = userService.getUser(login, password);
            session.setAttribute(user, tbUser);
            resp.sendRedirect("index.jsp");
        } catch (IncorrectLoginOrPasswordException e){
            session.setAttribute(messages, Collections.singletonList("Niepoprawne dane logowania"));
            resp.sendRedirect("login.jsp");
        }




//        final PrintWriter writer = res.getWriter();
//        final String userName = "admin";
//
//        if(login.equals(userName) && password.equals("password")){
//            final HttpSession session = req.getSession();
//
//            session.setAttribute("user", userName);
//            res.sendRedirect(req.getContextPath() + "/");
//
//
//        } else {
//            writer.write("Niepoprawne dane logowania");
//        }
    }

}
