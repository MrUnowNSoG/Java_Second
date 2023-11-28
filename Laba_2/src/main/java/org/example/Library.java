package org.example;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library implements IManageable {

    private String _nameLibrary;
    private List<Item> _itemsInStore;
    private List<Patron> _patrons;


    //Construction
    public Library() {
        _nameLibrary = "School Library";
        InitializationList();
    }

    public  Library(String name) {

        _nameLibrary = name;
        InitializationList();
    }

    private void InitializationList() {
        _itemsInStore = new ArrayList<Item>();
        _patrons = new ArrayList<Patron>();
    }
    //


    //Add methood
    public Item GetItem(int index) {
        return  _itemsInStore.get(index);
    }

    public Patron GetPatron(int index) {
        return  _patrons.get(index);
    }
    //


    @Override
    public void add(Item item) {
        for (Item items : _itemsInStore) {
            if(Objects.equals(items.uniqueID, item.uniqueID)) {
                System.out.println("Предмет з таким Id вже є в бібліотеці");
                return;
            }
        }

        _itemsInStore.add(item);
        System.out.println("Предмет добавлений в бібліотеку!");
    }

    @Override
    public void remove(Item item) {
        if(_itemsInStore.remove(item)) {
            System.out.println("З бібліотеки був успішно видалиний предмет!");
        } else System.out.println("Не вдалося видалити предмет, перевірте чи такий предмет є в бібліотеці!");
    }

    @Override
    public void listAvailable() {
        System.out.println(_nameLibrary + " має такі предмети:");

        for (Item item : _itemsInStore) {
            item.DisplayItem();
        }
    }

    @Override
    public void listBorrowed() {
        System.out.println("З " + _nameLibrary + " були взяті такі предмети:");

        for (Item item : _itemsInStore) {
            if(item.isBorrowed) {
                item.DisplayItem();
            }
        }
    }

    public void findItemAtName (String name){

        boolean goodFind = false;

        for (Item item : _itemsInStore) {
            if (item.title.equals(name)) {
                System.out.println();
                item.DisplayItem();

                goodFind = true;
                break;
            }
        }

        if(!goodFind) System.out.println("Такого предмета немає в бібліотеці.");
    }


    public void registerPatron(Patron patron) {
        for (Patron patrons : _patrons) {
            if(Objects.equals(patrons.idPatron, patron.idPatron)) {
                System.out.println("Кориcтувач з таким Id вже є в бібліотеці");
                return;
            }
        }

        _patrons.add(patron);
        System.out.println("Користувач добавлений в бібліотеку!");
    }

    public void LendItem(Patron patron, Item item) {
        int indexPatron = _patrons.indexOf(patron);

        if(indexPatron != -1) {
            int indexItem = _itemsInStore.indexOf(item);

            if(indexItem != -1 && !_itemsInStore.get(indexItem).isBorrowed) {

                _itemsInStore.get(indexItem).borrowItem();
                _patrons.get(indexPatron).Borrow(_itemsInStore.get(indexItem));

                System.out.println("Предмет був успішно взятий!");
                return;
            } else System.out.println("Такого предмета немає в бібліотеці.");
        } else System.out.println("Такого користувача немає в бібліотеці.");

    }

    public void ReturnItem(Patron patron, Item item) {
        int indexPatron = _patrons.indexOf(patron);

        if(indexPatron != -1) {
            int indexItem = _itemsInStore.indexOf(item);

            if(indexItem != -1 && _itemsInStore.get(indexItem).isBorrowed) {

                _itemsInStore.get(indexItem).returnItem();
                _patrons.get(indexPatron).Return(_itemsInStore.get(indexItem));

                System.out.println("Предмет був успішно повернутий!");
                return;
            } else System.out.println("Такого предмета немає в бібліотеці.");
        } else System.out.println("Такого користувача немає в бібліотеці.");
    }
}