package com.theironyard.charlotte;

/**
 * Created by Ben on 4/19/17.
 */
public class Food {
    private int STATIC_ID = 0;

    private int id;
    private String name;
    private int quantity;
    private boolean found;

    public Food() {
        id = STATIC_ID++;
    }

    public Food(String name, int quantity) {
        this();
        this.name = name;
        this.quantity = quantity;
        this.found = false;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }
}
