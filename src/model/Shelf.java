package model;

public class Shelf {

    private int id;

    private String codShelf;
    private int idWarehouse;

    public Shelf(int id, String codShelf, int idWarehouse) {
        this.id = id;
        this.codShelf = codShelf;
        this.idWarehouse = idWarehouse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodShelf() {
        return codShelf;
    }

    public void setCodShelf(String codShelf) {
        this.codShelf = codShelf;
    }

    public int getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWarehouse(int idWarehouse) {
        this.idWarehouse = idWarehouse;
    }
}
