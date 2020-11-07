package ru.geekbrains.shop;

import ru.geekbrains.shop.persist.Product;
import ru.geekbrains.shop.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/products/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");
        if (productRepository == null) {
            throw new ServletException("ToDo repository not initialized");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            if (req.getServletPath().equals("/products")) {
                List<Product> products = productRepository.findAll();
                req.setAttribute("products", products);

                getServletContext().getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req, resp);
            } else if (req.getServletPath().equals("/products/product")) {
                Long id = Long.parseLong(req.getParameter("id"));

                Product product = productRepository.findById(id);

                req.setAttribute("product", product);

                getServletContext().getRequestDispatcher("/WEB-INF/views/product.jsp").forward(req, resp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
