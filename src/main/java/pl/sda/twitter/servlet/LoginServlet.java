package pl.sda.twitter.servlet;

import pl.sda.twitter.exceptions.IncorrectLoginOrPasswordException;
import pl.sda.twitter.persistance.entities.TbUser;
import services.UserService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        try {
            final TbUser user = userService.getUser(login, password);
            resp.sendRedirect("index.jsp");
        } catch (IncorrectLoginOrPasswordException e){
            resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
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
