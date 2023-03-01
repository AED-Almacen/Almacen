package model;

public class Piece {
    private int id;
    private Float price;
    private String desc;
    private String codPiece;

    public Piece(int id, Float price, String desc, String codPiece) {
        this.id = id;
        this.price = price;
        this.desc = desc;
        this.codPiece = codPiece;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getPrice() {
        return this.price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCodPiece() {
        return this.codPiece;
    }

    public void setCodPiece(String codPiece) {
        this.codPiece = codPiece;
    }
}
