package by.tms.instaclonec26onl.servlet;

import by.tms.instaclonec26onl.model.User;
import by.tms.instaclonec26onl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
	private final UserService userService = new UserService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		getServletContext().
				getRequestDispatcher("/pages/login.jsp").
				forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		User byUsername = userService.findUserByUsername(username);
		if (byUsername.getPassword().equals(password)) {

			req.getSession().setAttribute("user", byUsername);
			resp.sendRedirect("/profile");
		} else {
			req.setAttribute("message", "Wrong password!");
			getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
		}
	}
}
