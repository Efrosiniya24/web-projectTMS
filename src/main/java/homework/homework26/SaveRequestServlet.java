package homework.homework26;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/save-request")
public class SaveRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/save-request.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone =req.getParameter("phone");

        if(name.isEmpty() || email.isEmpty() || phone.isEmpty())
            req.getRequestDispatcher("/WEB-INF/save-request.jsp").forward(req, resp);
        else
            req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }
}
