package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompPieceQueries {
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

    public CompPiece readCompPiece(int id) {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza_comp WHERE id = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CompPiece(id, rs.getInt("id_pieza"),
                        rs.getInt("id_pieza_comp"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
    }

    public ArrayList<CompPiece> readCompPiece() {
        Connection conn = ConnectionPool.getInstance().getConnection();
        String sql = "SELECT * FROM pieza_comp";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            ArrayList<CompPiece> compPieces = new ArrayList<>();

            while (rs.next()) {
                compPieces.add(new CompPiece(rs.getInt("id"),
                        rs.getInt("id_pieza"), rs.getInt("id_pieza_comp")));
            }

            if (compPieces.size() > 0) return compPieces;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionPool.getInstance().closeConnection(conn);
        }

        return null;
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
