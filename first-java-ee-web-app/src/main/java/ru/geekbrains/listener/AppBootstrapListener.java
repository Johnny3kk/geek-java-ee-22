package ru.geekbrains.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener
public class AppBootstrapListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(AppBootstrapListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Initializing application");

        ServletContext sc = sce.getServletContext();
        String jdbcConnectionString = sc.getInitParameter("jdbcConnectionString");
        String userName = sc.getInitParameter("username");
        String password = sc.getInitParameter("password");

        try {
            Connection connection = DriverManager.getConnection(jdbcConnectionString, userName, password);
            sc.setAttribute("jdbcConnection", connection);
        } catch (SQLException ex) {
            logger.error("Can't initialize JDBC connection", ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
