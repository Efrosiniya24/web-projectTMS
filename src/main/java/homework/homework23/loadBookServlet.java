package homework.homework23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
@WebServlet("/load-book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class loadBookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try {
            request.getRequestDispatcher("/WEB-INF/loadBook.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Part filePart = request.getPart("file");
            String name = filePart.getSubmittedFileName();
            filePart.write("D:\\books\\" + name);
            response.getWriter().print("Книга успешно скачана");
        } catch (Exception e) {
            response.getWriter().print("Ошибка... ");
        }
    }
}
