package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompPiecesQueries {
    public void createCompPiece(int idPiece, int idCompPiece) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "INSERT INTO pieza_comp (id_pieza, id_pieza_comp) VALUES (?, ?) ";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPiece);
            ps.setInt(2, idCompPiece);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public ArrayList<Piece> readCompPieces(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza_comp INNER JOIN pieza on pieza_comp.id_pieza_comp = pieza.id WHERE id_pieza = ?";

        ArrayList<Piece> compPieces = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compPieces.add(new Piece(rs.getInt("id"), rs.getFloat("precio"),
                        rs.getString("descripcion"), rs.getString("cod_pieza")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return compPieces;
    }

    public void updateCompPiece(int id, int idPiece, int idCompPiece) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "UPDATE pieza_comp SET  id_pieza = ?, id_pieza_comp = ? WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idPiece);
            ps.setInt(2, idCompPiece);
            ps.setInt(3, id);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }
    }

    public void deleteCompPiece(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "DELETE FROM pieza_comp WHERE id = ?";

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
