package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StokeQueries {
    public void createStoke(int amount, int idPiece, int idShelf) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO stoke (cantidad, id_pieza, id_estanterua) VALUES (?, ?, ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, idPiece);
            ps.setInt(3, idShelf);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public Stoke readStoke(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM stoke WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Stoke(id, rs.getInt("cantidad"), rs.getInt("id_pieza"),
                        rs.getInt("id_estanteria"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public ArrayList<Stoke> readStokes() {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM stoke";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<Stoke> stokes = new ArrayList<>();

            while (rs.next()) {
                stokes.add(new Stoke(rs.getInt("id"), rs.getInt("cantidad"),
                        rs.getInt("id_pieza"), rs.getInt("id_estanteria")));
            }

            if (stokes.size() > 0) return stokes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public void updateStoke(int id, int amount, int idPiece, int idShelf) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE stoke SET cantidad = ?, id_pieza = ?, id_estanteria = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, amount);
            ps.setInt(2, idPiece);
            ps.setInt(3, idShelf);
            ps.setInt(4, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public void deleteStoke(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "DELETE FROM stoke WHERE id = ?";

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
