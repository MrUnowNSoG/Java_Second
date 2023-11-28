package org.example;

public abstract class Item {

    public String title;
    public String uniqueID;
    public boolean isBorrowed;

    public Item(String title, String uniqueID) {
        this.title = title;
        this.uniqueID = uniqueID;
        isBorrowed = false;
    }

    public abstract void borrowItem();


    public abstract void returnItem();

    public abstract void DisplayItem();
}
