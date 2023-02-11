package model;

public class Nut {
    private int id;
    private Float price;
    private String desc;
    private String codNut;

    public Nut(int id, Float price, String desc, String codNut) {
        this.id = id;
        this.price = price;
        this.desc = desc;
        this.codNut = codNut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCodNut() {
        return codNut;
    }

    public void setCodNut(String codNut) {
        this.codNut = codNut;
    }
}
