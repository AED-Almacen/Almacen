package model;

public class Stoke {
    private int id;
    private int amount;
    private int idPiece;
    private int idShelf;

    public Stoke(int id, int amount, int idPiece, int idShelf) {
        this.id = id;
        this.amount = amount;
        this.idPiece = idPiece;
        this.idShelf = idShelf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
    }

    public int getIdShelf() {
        return idShelf;
    }

    public void setIdShelf(int idShelf) {
        this.idShelf = idShelf;
    }
}
