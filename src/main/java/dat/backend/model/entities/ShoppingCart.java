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

public class ShoppingCart
{
    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    private List<Cupcake> cupcakeList = new ArrayList<>();

    public ShoppingCart()
    {
    }

    public void add(Cupcake cupcake)
    {
        cupcakeList.add(cupcake);
    }

    public int getNumberOfCupcakes() //få antal ordrer
    {
        return cupcakeList.size();
    }

    public Object seeOrderLines(){
        CupcakeMapper.seeOrderlines(connectionPool);
        return null;
    }

    public List<Cupcake> getCupcakeList()
    {
        return cupcakeList;
    }

    public void resetCart()
    {
        cupcakeList.clear();
    }

    public int priceOrder(ShoppingCart cart, ConnectionPool connectionPool){
        int price = 0;
        String sql = "select order_lines (" +
                "order_id, top_id, bottom_id, " +
                "top_price, bottom_price, quantity ) values (?,?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection()) {
            for (Cupcake cupcake : cart.getCupcakeList()) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    //ps.setInt(1, cupcakeList.get(1,order_line_id));
                    ps.setInt(2, cupcake.getTop().getId());
                    ps.setInt(3, cupcake.getBottom().getId());
                    ps.setDouble(4, cupcake.getTop().getPrice());
                    ps.setDouble(5, cupcake.getBottom().getPrice());
                    ps.setInt(6, cupcake.getQuantity());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        price += (int) (cupcake.getTop().getPrice()+cupcake.getBottom().getPrice()*(cupcake.getQuantity()));
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }

}
