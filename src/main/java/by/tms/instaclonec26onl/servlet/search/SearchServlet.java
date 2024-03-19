package by.tms.instaclonec26onl.servlet.search;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private final UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User("ilia","lil","qwe","",new ArrayList<>(),new ArrayList<>());
        User user1 = new User("ilia","lil1","qwe2","",new ArrayList<>(),new ArrayList<>());

        userService.add(user);
        userService.add(user1);

        getServletContext().getRequestDispatcher("/pages/search/search.jsp").forward(req, resp);

    }
}
