package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShelfQueries {
    public void createShelf( String codShelf, int idWarehouse ) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO estanteria (cod_estanteria, id_almacen) VALUES ( ?, ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codShelf);
            ps.setInt(2, idWarehouse);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public Shelf readShelf(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM estanteria WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Shelf(id, rs.getString("cod_estanteria"), rs.getInt("id_almacen"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public ArrayList<Shelf> readShelves() {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM estanteria";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Shelf> shelves = new ArrayList<>();

            while (rs.next()) {
                shelves.add(new Shelf(rs.getInt("id"), rs.getString("cod_estanteria"), rs.getInt("id_almacen")));
            }

            if (shelves.size() > 0) return shelves;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public void updateShelf(int id, String codShelf, int idWarehouse) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE estanteria SET cod_estanteria = ?, id_almacen = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, codShelf);
            ps.setInt(2, idWarehouse);
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public void deleteShelf(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "DELETE FROM estanteria WHERE id = ?";

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
