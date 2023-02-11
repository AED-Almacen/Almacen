package model;

import java.sql.*;
import java.util.ArrayList;

public class NutQueries {

    public void createNut(float price, String desc, String codNut) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO pieza (precio, descripcion, cod_pieza) VALUES (?, ?, ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, desc);
            ps.setString(3, codNut);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public Nut readNut(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Float price = rs.getFloat("precio");
                String desc = rs.getString("descripcion");
                String codNut = rs.getString("cod_pieza");

                return new Nut(id, price, desc, codNut);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public ArrayList<Nut> readNuts() {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            int i = 0;
            ArrayList<Nut> nuts = new ArrayList<>();

            while (rs.next()) {
                nuts.add(new Nut(rs.getInt("id"), rs.getFloat("precio"),
                        rs.getString("descripcion"), rs.getString("cod_pieza")));

                i++;
            }

            if (nuts.size() > 0) return nuts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public void updateNut(int id, float price, String desc, String codNut) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE pieza SET precio = ?, descripcion = ?, cod_pieza = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, desc);
            ps.setString(3, codNut);
            ps.setInt(4, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public void deleteNut(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "DELETE FROM pieza WHERE id = ?";

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
