package com.jackingaming.librarydvd;

public class Dvd {

    private int id;
    private String name;
    private boolean isCheckedOut;

    public Dvd(int id, String name, boolean isCheckedOut) {
        this.id = id;
        this.name = name;
        this.isCheckedOut = isCheckedOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

}