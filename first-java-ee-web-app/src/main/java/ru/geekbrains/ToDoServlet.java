package ru.geekbrains;

import ru.geekbrains.persist.ToDo;
import ru.geekbrains.persist.ToDoRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = {"", "/"})
public class ToDoServlet extends HttpServlet {

    private ToDoRepository toDoRepository;

    @Override
    public void init() throws ServletException {
        toDoRepository = (ToDoRepository) getServletContext().getAttribute("toDoRepository");
        if (toDoRepository == null) {
            throw new ServletException("ToDo repository not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<ToDo> todos = toDoRepository.findAll();
            req.setAttribute("todos", todos);

            getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}
