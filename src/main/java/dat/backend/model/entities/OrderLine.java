package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CupcakeMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLine
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    private List<ShoppingCart> orderList = new ArrayList<>();

    public OrderLine()
    {
    }

    public void add(ShoppingCart shoppingCart)
    {
        orderList.add(shoppingCart);
    }

    public int getNumberOfOrders() //få antal ordrer
    {
        return orderList.size();
    }

    public ShoppingCart seeOrderLines(){
        CupcakeMapper.seeOrderlines(connectionPool);
        return null;
    }

    public List<ShoppingCart> getOrderList()
    {
        return orderList;
    }

    public void resetOrders()
    {
        orderList.clear();
    }

//    public int priceOrder(OrderLine orderLine, ConnectionPool connectionPool){
//        int price = 0;
//        String sql = "select order_lines (" +
//                "order_id, top_id, bottom_id, " +
//                "top_price, bottom_price, quantity ) values (?,?,?,?,?,?)";
//
//        try (Connection connection = connectionPool.getConnection()) {
//            for (ShoppingCart shoppingCart : orderLine.orderList()) {
//                try (PreparedStatement ps = connection.prepareStatement(sql)) {
//                    //ps.setInt(1, cupcakeList.get(1,order_line_id));
//                    ps.setInt(2, "shoppingCart.getCupcakeList()");
//                    ps.setInt(3, shoppingCart.getBottom().getId());
//                    ps.setDouble(4, shoppingCart.getTop().getPrice());
//                    ps.setDouble(5, shoppingCart.getBottom().getPrice());
//                    ps.setInt(6, shoppingCart.getQuantity());
//                    ResultSet rs = ps.executeQuery();
//                    while (rs.next()) {
//                        price += (int) (cupcake.getTop().getPrice()+cupcake.getBottom().getPrice()*(cupcake.getQuantity()));
//                    }
//
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return price;
//    }

}
