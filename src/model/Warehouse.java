package model;

import java.util.Objects;

public class Warehouse  {
    private final int id;
    private final String desc;
    private final String address;

    public Warehouse(int id, String desc, String address) {
        this.id = id;
        this.desc = desc;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return this.desc;
    }

    public String getAddress() {
        return this.address;
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
        if(!Objects.equals(desc, that.desc)) return false;
        if(!Objects.equals(address, that.address)) return false;
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
