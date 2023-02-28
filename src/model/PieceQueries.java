package model;

import java.sql.*;
import java.util.ArrayList;

public class PieceQueries {

    public void createPiece(float price, String desc, String codPiece) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO pieza (precio, descripcion, cod_pieza) VALUES (?, ?, ?) ";



        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, desc);
            ps.setString(3, codPiece);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public Piece readPiece(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Piece(id, rs.getFloat("precio"),
                        rs.getString("descripcion"), rs.getString("cod_pieza"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public ArrayList<Piece> readPieces() {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza";

        ArrayList<Piece> pieces = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                pieces.add(new Piece(rs.getInt("id"), rs.getFloat("precio"),
                        rs.getString("descripcion"), rs.getString("cod_pieza")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return pieces;
    }

    public void updatePiece(int id, float price, String desc, String codPiece) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE pieza SET precio = ?, descripcion = ?, cod_pieza = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setFloat(1, price);
            ps.setString(2, desc);
            ps.setString(3, codPiece);
            ps.setInt(4, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public void deletePiece(int id) {
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
