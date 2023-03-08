package model;

public class Shelf {

    private final int id;
    private final String codShelf;
    private final int idWarehouse;

    public Shelf(int id, String codShelf, int idWarehouse) {
        this.id = id;
        this.codShelf = codShelf;
        this.idWarehouse = idWarehouse;
    }

    public int getId() {
        return id;
    }

    public String getCodShelf() {
        return codShelf;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    @Override
    public String toString() {
        return "Shelf{" +
                "id=" + id +
                ", codShelf='" + codShelf + '\'' +
                ", idWarehouse=" + idWarehouse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shelf shelf = (Shelf) o;

        if (id != shelf.id) return false;
        if (idWarehouse != shelf.idWarehouse) return false;
        return codShelf.equals(shelf.codShelf);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + codShelf.hashCode();
        result = 31 * result + idWarehouse;
        return result;
    }
}
