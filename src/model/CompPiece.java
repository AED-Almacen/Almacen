package model;

public class CompPiece {
    private int id;
    private int idPiece;
    private int idCompPiece;

    public CompPiece(int id, int idPiece, int idCompPiece) {
        this.id = id;
        this.idPiece = idPiece;
        this.idCompPiece = idCompPiece;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

    public int getIdCompPiece() {
        return idCompPiece;
    }

    public void setIdCompPiece(int idCompPiece) {
        this.idCompPiece = idCompPiece;
    }
}
