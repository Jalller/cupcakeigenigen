package dat.backend.model.persistence;

import dat.backend.control.Order;
import dat.backend.model.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderMapper {

    Connection connection;
    
    public static List<ShoppingCart> getAllShoppingCarts(ConnectionPool connectionPool) {
        List<ShoppingCart> ShoppingCartList = new ArrayList<>();
        String sql = "select * from ShoppingCart_lines";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_line_id = rs.getInt("order_line_id");
                    int order_id = rs.getInt("order_line_id");
                    int top_id = rs.getInt("top_id");
                    int bottom_id = rs.getInt("bottom_id");
                    int top_price = rs.getInt("top_price");
                    int bottom_price = rs.getInt("bottom_price");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ShoppingCartList;
    }

    public static void insertShoppingCartLines(int ShoppingCartId, ShoppingCart cart, ConnectionPool connectionPool) {
        String sql = "insert into ShoppingCart_lines (" +
                "ShoppingCart_id, top_id, bottom_id, " +
                "top_price, bottom_price, quantity ) values (?,?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            for (Cupcake cupcake : cart.getCupcakeList()) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, ShoppingCartId);
                    ps.setInt(2, cupcake.getTop().getId());
                    ps.setInt(3, cupcake.getBottom().getId());
                    ps.setDouble(4, cupcake.getTop().getPrice());
                    ps.setDouble(5, cupcake.getBottom().getPrice());
                    ps.setInt(6, cupcake.getQuantity());
                    ps.executeUpdate();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int priceShoppingCart(int ShoppingCartId, ShoppingCart cart, ConnectionPool connectionPool) {
        int price = 0;
        String sql = "insert into ShoppingCart_lines (" +
                "ShoppingCart_id, top_id, bottom_id, " +
                "top_price, bottom_price, quantity ) values (?,?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            for (Cupcake cupcake : cart.getCupcakeList()) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, ShoppingCartId);
                    ps.setInt(2, cupcake.getTop().getId());
                    ps.setInt(3, cupcake.getBottom().getId());
                    ps.setDouble(4, cupcake.getTop().getPrice());
                    ps.setDouble(5, cupcake.getBottom().getPrice());
                    ps.setInt(6, cupcake.getQuantity());
                    ps.executeUpdate();

                    price = (int) (cupcake.getTop().getPrice() + cupcake.getBottom().getPrice() * (cupcake.getQuantity()));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

    public double getTotalPrice(int ShoppingCart_line_id, List<ShoppingCart> cart) {
        double price = 0;
        try {

            if (cart.size() > 0) {
                for (ShoppingCart item : cart) {

                    String sql = "select * from ShoppingCart_lines where ShoppingCart_line_id = ?";


                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps = this.connection.prepareStatement(sql);

                    ps.setInt(1, ShoppingCart_line_id);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        price += rs.getDouble("price") * item.getNumberOfCupcakes();
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    public static int seeShoppingCartlines(ConnectionPool connectionPool) {
        Logger.getLogger("web").log(Level.INFO, "");
        User user;
        String sql = "Select * from ShoppingCart_lines";
        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    int order_line_id = rs.getInt("order_line_id");
                    int order_id = rs.getInt("order_id");
                    int top_id = rs.getInt("top_id");
                    int bottom_id = rs.getInt("bottom_id");
                    int top_price = rs.getInt("top_price");
                    int bottom_price = rs.getInt("bottom_price");
                    int quantity = rs.getInt("quantity");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }
}



