package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

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

    /**
     * Constructor is like a reset, used to first set up the FoodInventory class or reset it
     */
    public FoodInventory() {
        // Constructor is like a reset, used to first set up the FoodInventory class
        // or reset it

        // Initialize inventory
        readDatabaseInventory();
        // Initialize inventory calories to 0
        setInventoryGrainCalories(0);
        setInventoryVeggieCalories(0);
        setInventoryProteinCalories(0);
        setInventoryOtherCalories(0);
        // Calculate inventory calories from inventory
        Iterator<String[]> inventoryIterator = inventory.iterator();
        while (inventoryIterator.hasNext()) {
            String[] foodItem = inventoryIterator.next();
            inventoryGrainCalories += Integer.parseInt(foodItem[2]);
            inventoryVeggieCalories += Integer.parseInt(foodItem[3]);
            inventoryProteinCalories += Integer.parseInt(foodItem[4]);
            inventoryOtherCalories += Integer.parseInt(foodItem[5]);
        }
    }

    /**
     * Reads food inventory from database
     * @return True if read was successfull. False if read failed.
     */
    public static boolean readDatabaseInventory() {
        try {
            inventory = DatabaseReader.readInventory();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public static boolean updateDatabase() {
        return true;
    }

    /**
     * Checks if current inventory has enough food items to fulfil the caloric needs of a hamper
     * @return False if there is no food shortage. This means inventory has enough food for a hamper.
     * True if there is a food shortage. This means inventory does not have enough food for a hamper.
     */
    public static boolean checkShortage() {
        return true;
    }

    public static boolean removeHamper(ArrayList<String[]> hamperContents) {
        return true;
    }

    //Getters and Setters

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
}
