package homework.homework23;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Приложение работает");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Приложение закончило свою работу");
    }
}
