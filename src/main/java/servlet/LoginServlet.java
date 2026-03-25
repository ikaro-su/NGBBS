package servlet;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String userIdStr = request.getParameter("userId");
        String password = request.getParameter("password");

        if (userIdStr == null || userIdStr.isEmpty() ||
            password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "ユーザーIDまたはパスワードが未入力です。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return;
        }

        try {
            int userId = Integer.parseInt(userIdStr);

            UserDAO userDAO = new UserDAO();
            User user = userDAO.findUser(userId, password);

            if (user != null) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "ログインに失敗しました。");
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }

        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "ユーザーIDは数値で入力してください。");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}