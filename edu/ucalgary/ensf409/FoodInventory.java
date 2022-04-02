package edu.ucalgary.ensf409;

import java.util.ArrayList;

/**
 * @since 1.0
 * @version 1.3
 */
public class FoodInventory {
    private static ArrayList<String[]> inventory = new ArrayList<>();
    private static ArrayList<String[]> toBeRemoved = new ArrayList<>();
    private static int inventoryProteinCalories;
    private static int inventoryVeggieCalories;
    private static int inventoryGrainCalories;
    private static int inventoryOtherCalories;

    public FoodInventory() {
        
    }

    public static boolean readDatabaseInventory() {
        return true;
    }

    public static boolean updateDatabase() {
        return true;
    }

    public static boolean checkShortage() {
        return true;
    }

    public static boolean removeHamper(ArrayList<String[]> hamperContents) {
        return true;
    }

    public static ArrayList<String[]> getInventory() {
        return inventory;
    }

    public static void setInventory(ArrayList<String[]> inventory) {
        FoodInventory.inventory = inventory;
    }

    public static int getInventoryProteinCalories() {
        return inventoryProteinCalories;
    }

    public static void setInventoryProteinCalories(int inventoryProteinCalories) {
        FoodInventory.inventoryProteinCalories = inventoryProteinCalories;
    }

    public static int getInventoryVeggieCalories() {
        return inventoryVeggieCalories;
    }

    public static void setInventoryVeggieCalories(int inventoryVeggieCalories) {
        FoodInventory.inventoryVeggieCalories = inventoryVeggieCalories;
    }

    public static int getInventoryGrainCalories() {
        return inventoryGrainCalories;
    }

    public static void setInventoryGrainCalories(int inventoryGrainCalories) {
        FoodInventory.inventoryGrainCalories = inventoryGrainCalories;
    }

    public static int getInventoryOtherCalories() {
        return inventoryOtherCalories;
    }

    public static void setInventoryOtherCalories(int inventoryOtherCalories) {
        FoodInventory.inventoryOtherCalories = inventoryOtherCalories;
    }

    //Getters and Setters
    
}
