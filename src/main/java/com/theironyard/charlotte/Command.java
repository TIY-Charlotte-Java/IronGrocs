package com.theironyard.charlotte;

/**
 * Created by Ben on 4/19/17.
 */
public class Command {
    private String command;
    private String name;
    private int id;
    private int quantity;
    private boolean found;

    public Command() {
    }

    public Command(String command, String name, int foodId, int quantity, boolean found) {
        this.command = command;
        this.name = name;
        this.id = foodId;
        this.quantity = quantity;
        this.found = found;
    }

    public boolean isFound() {
        return found;
    }

    public void setFound(boolean found) {
        this.found = found;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
