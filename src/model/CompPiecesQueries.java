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

    public ArrayList<CompPieces> readCompPieces(int id_piece) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza_comp WHERE id_pieza = ?";

        ArrayList<CompPieces> compPieces = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_piece);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                compPieces.add(new CompPieces(rs.getInt("id"), rs.getInt("id_pieza"),
                        rs.getInt("id_pieza_comp")));
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
        String sql = "UPDATE pieza_comp SET id_pieza = ?, id_pieza_comp = ? WHERE id = ?";

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
