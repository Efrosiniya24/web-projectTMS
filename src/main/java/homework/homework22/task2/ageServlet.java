package homework.homework22.task2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class ageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] path = req.getServletPath().split("/");
        resp.setContentType("text/html");
        try {
            int age = Integer.parseInt(path[path.length - 1]);
            if (age >= 18)
                resp.getWriter().println("<h1>Совершеннолетний</h1>");
            else
                resp.getWriter().println("<h1>Несовершеннолетний</h1>");
        } catch (NumberFormatException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.getWriter().println("<h1>Неверный формат возраста</h1>");
        }
    }
}