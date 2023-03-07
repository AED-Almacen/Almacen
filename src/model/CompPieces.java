package model;

public class CompPieces {
    private int id;

    private int id_piece;
    private int id_pieceComp;

    public CompPieces(int id, int id_piece, int id_pieceComp) {
        this.id = id;
        this.id_piece = id_piece;
        this.id_pieceComp = id_pieceComp;
    }

    public int getId() {
        return id;
    }

    public int getId_piece() {
        return id_piece;
    }

    public int getId_pieceComp() {
        return id_pieceComp;
    }
}
