package com.theironyard.charlotte;

/**
 * Created by Ben on 4/19/17.
 */
public class Command {
    private String command;
    private String name;
    private int foodId;
    private int quantity;

    public Command() {
    }

    public Command(String command, String name, int foodId, int quantity) {
        this.command = command;
        this.name = name;
        this.foodId = foodId;
        this.quantity = quantity;
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

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
