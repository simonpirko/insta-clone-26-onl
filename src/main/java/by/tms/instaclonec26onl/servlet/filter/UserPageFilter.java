package by.tms.instaclonec26onl.servlet.filter;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"userPageServlet"})
public class UserPageFilter extends HttpFilter {
    private final UserService userService = new UserService();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        User myProfile = (User) req.getSession().getAttribute("user");
        String username = req.getParameter("username");
        User byUsername;
        byUsername = userService.findByUsername(username);
        if (!myProfile.getUsername().equals(byUsername.getUsername())) {
            chain.doFilter(req, res);
        }
        res.sendRedirect("/profile");
    }
}
