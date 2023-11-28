package org.example;
public class DVD extends Item {

    private int _duration;

    public int getDuraion() {
        return  _duration;
    }

    public void setDuration(int duration) {
        if(duration > 0) {
            this._duration = duration;
        }
    }

    public DVD(String title, String uniqueID, int duration) {
        super(title, uniqueID);
        _duration = duration;
    }


    @Override
    public void borrowItem() {
        isBorrowed = true;
        System.out.println("З бібліотеки був взят DVD: " + title);
    }

    @Override
    public void returnItem() {
        isBorrowed = false;
        System.out.println("В бібліотеку був повернутий DVD: " + title);
    }

    @Override
    public void DisplayItem() {
        System.out.println("DVD з назвою: " + title + ". Довжиною: " + getDuraion());
    }
}
