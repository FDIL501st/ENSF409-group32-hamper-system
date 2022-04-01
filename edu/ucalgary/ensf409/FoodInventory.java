package edu.ucalgary.ensf409;

import java.util.ArrayList;
/**
 * @since 1.0
 * @version 1.1
 */
public class FoodInventory {
    private ArrayList<ArrayList<String>> inventory = new ArrayList<>(2);
    private ArrayList<ArrayList<String>> toBeRemoved;
    private int inventoryProteinCalories;
    private int inventoryVeggieCalories;
    private int inventoryGrainCalories;
    private int inventoryOtherCalories;

    public FoodInventory() {
        
    }

    public boolean readDatabaseInventory() {
        return true;
    }

    public boolean updateDatabase() {
        return true;
    }

    public boolean checkShortage() {
        return true;
    }

    public boolean removeHamper(ArrayList<String> hamperContents) {
        return true;
    }

    //Getters and Setters
    public ArrayList<String> getInventory() { 
        return inventory.get(1); 
    }
    public void setInventory(ArrayList<String> inventory) {
        this.inventory.get(1).clear();
        this.inventory.add(1, inventory);
    }
    public int getInventoryProteinCalories() {
        return inventoryProteinCalories;
    }

    public void setInventoryProteinCalories(int inventoryProteinCalories) {
        this.inventoryProteinCalories = inventoryProteinCalories;
    }

    public int getInventoryVeggieCalories() {
        return inventoryVeggieCalories;
    }

    public void setInventoryVeggieCalories(int inventoryVeggieCalories) {
        this.inventoryVeggieCalories = inventoryVeggieCalories;
    }

    public int getInventoryGrainCalories() {
        return inventoryGrainCalories;
    }

    public void setInventoryGrainCalories(int inventoryGrainCalories) {
        this.inventoryGrainCalories = inventoryGrainCalories;
    }

    public int getInventoryOtherCalories() {
        return inventoryOtherCalories;
    }

    public void setInventoryOtherCalories(int inventoryOtherCalories) {
        this.inventoryOtherCalories = inventoryOtherCalories;
    }

}
