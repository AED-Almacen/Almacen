package model;

import java.util.Objects;

public class Piece {
    private final int id;
    private final Float price;
    private final String desc;
    private final String codPiece;

    public Piece(int id, Float price, String desc, String codPiece) {
        this.id = id;
        this.price = price;
        this.desc = desc;
        this.codPiece = codPiece;
    }

    public int getId() {
        return this.id;
    }

    public Float getPrice() {
        return this.price;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getCodPiece() {
        return this.codPiece;
    }

    @Override
    public String toString() {
        return "Piece{" +
                "id=" + id +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                ", codPiece='" + codPiece + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (id != piece.id) return false;
        if (!Objects.equals(price, piece.price)) return false;
        if (!Objects.equals(desc, piece.desc)) return false;
        return Objects.equals(codPiece, piece.codPiece);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (codPiece != null ? codPiece.hashCode() : 0);
        return result;
    }
}
