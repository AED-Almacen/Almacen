package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarehouseQueries {
    public void createWarehouse( String desc, String adress) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO almacen (direccion, descripcion) VALUES (?, ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, adress);
            ps.setString(2, desc);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public Warehouse readWarehouse(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM almacen WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String desc = rs.getString("direccion");
                String adress = rs.getString("descripcion");

                return new Warehouse(id, adress, desc);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public ArrayList<Warehouse> readWarehouses() {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM almacen";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int i = 0;
            ArrayList<Warehouse> warehouses = new ArrayList<>();

            while (rs.next()) {
                warehouses.add(new Warehouse(rs.getInt("id"), rs.getString("direccion"), rs.getString("descripcion")));
                i++;
            }

            if (warehouses.size() > 0) return warehouses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public void updateWarehouse(int id, String adress, String desc) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE almacen SET  direccion = ?, descripcion = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, adress);
            ps.setString(2, desc);
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public void deleteWarehouse(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "DELETE FROM almacen WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }
}
