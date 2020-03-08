package pl.sda.twitter.servlet;

import pl.sda.twitter.exceptions.IncorrectLoginOrPasswordException;
import pl.sda.twitter.persistance.entities.TbUser;
import services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try {
            final TbUser user = userService.getUser(login, password);
            final HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("index.jsp");
        } catch (IncorrectLoginOrPasswordException e){
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
