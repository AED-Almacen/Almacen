package model;

public class CompPieces {
    private final int id;
    private final int id_piece;
    private final int id_pieceComp;

    public CompPieces(int id, int id_piece, int id_pieceComp) {
        this.id = id;
        this.id_piece = id_piece;
        this.id_pieceComp = id_pieceComp;
    }

    public int getId() {
        return id;
    }

    public int getId_pieceComp() {
        return id_pieceComp;
    }

    @Override
    public String toString() {
        return "CompPieces{" +
                "id=" + id +
                ", id_piece=" + id_piece +
                ", id_pieceComp=" + id_pieceComp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompPieces that = (CompPieces) o;

        if (id != that.id) return false;
        if (id_piece != that.id_piece) return false;
        return id_pieceComp == that.id_pieceComp;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + id_piece;
        result = 31 * result + id_pieceComp;
        return result;
    }
}
