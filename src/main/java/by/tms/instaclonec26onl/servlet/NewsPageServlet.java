package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.model.UserPost;
import by.tms.instaclonec26onl.storage.PostDAO;
import by.tms.instaclonec26onl.storage.SubscriberDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/news")
public class NewsPageServlet extends HttpServlet {
    SubscriberDAO subscriberDAO = new SubscriberDAO();
    PostDAO postDAO = new PostDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        List<User> subscriptions = subscriberDAO.findSubUser(user.getId());
        List<UserPost> newsFeedPosts = new ArrayList<>();
        for (User subscription : subscriptions) {
            List<UserPost> posts = postDAO.findAllPostUser(subscription);
            newsFeedPosts.addAll(posts);
        }
        req.setAttribute("newsFeedPosts", newsFeedPosts);
        getServletContext().getRequestDispatcher("/pages/news.jsp").forward(req,resp);
    }

}
