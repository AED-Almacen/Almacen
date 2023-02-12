package model;

import java.util.Objects;

public class Warehouse  {
    private int id;
    private String desc;
    private String address;

    public Warehouse(int id, String desc, String address) {
        this.id = id;
        this.desc = desc;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id:" + id +", Descripción: " + desc +", Dirección: " + address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Warehouse that = (Warehouse) o;
        if(desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if(address != null ? !address.equals(that.address) : that.address != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result =  Math.toIntExact(id);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
