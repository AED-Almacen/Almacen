package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class WarehouseQueries {
    public void createWarehouse(String desc, String address) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO almacen (descripcion, direccion) VALUES (?, ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, desc);
            ps.setString(2, address);
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
                return new Warehouse(id, rs.getString("direccion"),
                        rs.getString("descripcion"));
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
        String sql = "SELECT * FROM almacen ORDER BY id ASC";

        ArrayList<Warehouse> warehouses = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                warehouses.add(new Warehouse(rs.getInt("id"),
                        rs.getString("descripcion"), rs.getString("direccion")));
            }

            if (warehouses.size() > 0) return warehouses;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return warehouses;
    }

    public void updateWarehouse(int id, String desc, String address) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE almacen SET descripcion = ?, direccion = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, desc);
            ps.setString(2, address);
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
