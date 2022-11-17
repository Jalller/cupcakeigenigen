package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Bottom;
import dat.backend.model.entities.Cupcake;
import dat.backend.model.entities.ShoppingCart;
import dat.backend.model.entities.Top;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AdminSite", value = "/adminsite")

public class AdminSite extends HttpServlet {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        int order_line_id = Integer.parseInt(request.getParameter("order_line_id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int top_id = Integer.parseInt(request.getParameter("top_id"));
        int bottom_id = Integer.parseInt(request.getParameter("bottom_id"));
        int top_price = Integer.parseInt(request.getParameter("top_price"));
        int bottom_price = Integer.parseInt(request.getParameter("bottom_price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));


        session.setAttribute("orderline",cart.seeOrderLines());

        request.getRequestDispatcher("WEB-INF/adminsite.jsp").forward(request, response);
    }
}
