package homework.homework23;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

@WebServlet("/book")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10)
public class bookServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookName = request.getParameter("bookName");
        String filePath = "D:\\books\\" + bookName;
        File file = new File(filePath);
        if (file.exists()) {
            response.setContentType("application/octet-stream");
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment; filename=\"" + bookName + "\"");
            try (FileInputStream fis = new FileInputStream(file); OutputStream out = response.getOutputStream()) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                throw new ServletException("Невозможно скачать файл", e);
            }
        } else
            response.getWriter().println("Книга не найдена");
        response.setContentType("text/html");
        try {
            request.getRequestDispatcher("/WEB-INF/book.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

}
