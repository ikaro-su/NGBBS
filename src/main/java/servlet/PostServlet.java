package servlet;

import java.io.IOException;

import dao.PostDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/PostServlet")
public class PostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return;
        }

        String content = request.getParameter("content");

        if (content == null || content.trim().isEmpty()) {
            request.setAttribute("errorMessage", "投稿内容を入力してください。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        int userId = user.getUserId();

        PostDAO postDAO = new PostDAO();
        postDAO.insert(userId, content);

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }
}