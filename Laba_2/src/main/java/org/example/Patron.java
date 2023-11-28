package org.example;
import java.util.ArrayList;
import java.util.List;

public class Patron {

    public String name;
    public String idPatron;

    public List<Item> borrowItem;

    public Patron(String name, String id) {
        this.name = name;
        this.idPatron = id;
        borrowItem = new ArrayList<Item>();
    }

    public void Borrow(Item item) {
        borrowItem.add(item);
        item.borrowItem();
    }

    public  void Return(Item item) {
        borrowItem.remove(item);
        item.returnItem();
    }

    public Item GetItemForIndex(int i) {
        if(i >= 0 && i < borrowItem.size()) {
            return borrowItem.get(i);
        } return null;
    }

    public int GetSize() {
        return  borrowItem.size();
    }
}
