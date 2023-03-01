package model;

import java.util.ArrayList;

public class CompPieces {
    private int id;
    private final int idPiece;
    private final ArrayList<Piece> compPieces;

    public CompPieces(int id, int idPiece) {
        this.id = id;
        this.idPiece = idPiece;
        this.compPieces = new ArrayList<>();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPiece() {
        return this.idPiece;
    }

    public ArrayList<Piece> getCompPieces() {
        return this.compPieces;
    }
}
