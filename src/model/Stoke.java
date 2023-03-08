package model;

public class Stoke {
    private final int id;
    private final int amount;
    private final int idPiece;
    private final int idShelf;

    public Stoke(int id, int amount, int idPiece, int idShelf) {
        this.id = id;
        this.amount = amount;
        this.idPiece = idPiece;
        this.idShelf = idShelf;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getIdPiece() {
        return this.idPiece;
    }

    public int getIdShelf() {
        return this.idShelf;
    }

    @Override
    public String toString() {
        return "Stoke{" +
                "id=" + id +
                ", amount=" + amount +
                ", idPiece=" + idPiece +
                ", idShelf=" + idShelf +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stoke stoke = (Stoke) o;

        if (id != stoke.id) return false;
        if (amount != stoke.amount) return false;
        if (idPiece != stoke.idPiece) return false;
        return idShelf == stoke.idShelf;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + amount;
        result = 31 * result + idPiece;
        result = 31 * result + idShelf;
        return result;
    }
}
