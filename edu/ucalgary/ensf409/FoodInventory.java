package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @since 1.0
 * @version 1.5
 */
public class FoodInventory {
    private static ArrayList<String[]> inventory = new ArrayList<>();
    private static ArrayList<String[]> toBeRemoved = new ArrayList<>();
    private static double inventoryProteinCalories;
    private static double inventoryVeggieCalories;
    private static double inventoryGrainCalories;
    private static double inventoryOtherCalories;

    /**
     * Constructor causes the class to sync up with the available_food database
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
            inventoryGrainCalories += Double.parseDouble(foodItem[2]);
            inventoryVeggieCalories += Double.parseDouble(foodItem[3]);
            inventoryProteinCalories += Double.parseDouble(foodItem[4]);
            inventoryOtherCalories += Double.parseDouble(foodItem[5]);
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

    /**
     * Updates database by syncing the database with current FoodInventory. Also clears toBeRemoved.
     * @return true if all the items in toBeRemoved was removed from the database. 
     * False if at least one item in toBeRemoved was not removed from database. 
     * @implNote Goes and removes all items in toBeRemoved by itemID one by one in a loop.
     * The function only stops during the loop if an SQLException is thrown.
     * Otherwise, it will go through and try to delete all food items in toBeRemoved and 
     * after the loop return true or false.
     * @implSpec This returning false means FoodInventory and the database are not in sync.
     * In that case, it is a good idea to call the contructor to
     * sync FoodInventory up with the database. 
     *  
     */
    public static boolean updateDatabase() {
        // Sync database with FoodInventory
        Iterator<String[]> toBeRemovedIterator = toBeRemoved.iterator();
        int numDeleted = 0;
        // Loop through all items that need to be deleted from database and 
        // delete them one at a time
        while (toBeRemovedIterator.hasNext()) {
            int itemID = Integer.parseInt(toBeRemovedIterator.next()[0]);
            try {
                numDeleted += DatabaseReader.deleteFoodItem(itemID);
            } catch (SQLException e) {
                return false;
            }
        }
        // Clear toBeRemoved as its job is done and 
        // don't want to accidently try to use it again to remove items from database
        // that already has been removed
        toBeRemoved.clear();

        if (numDeleted != toBeRemoved.size()) {
            return false;
        }
        return true;
    }

    /**
     * Checks if current inventory has enough food items to fulfil the caloric needs of a hamper.
     * @param neededCalories An array which holds information of how much calories is needed by a hamper.
     * First element should be grain calories needed, second should be fruit and veggie calorie, 
     * third should be protein calorie needed and fourth element should be other calorie needed.
     * @return False if there is no food shortage. This means inventory has enough food for a hamper.
     * True if there is a food shortage. This means inventory does not have enough food for a hamper.
     */
    public static boolean checkShortage(double[] neededCalories) {
        if (neededCalories[0] < inventoryGrainCalories) {
            return false;
        }
        if (neededCalories[1] < inventoryVeggieCalories) {
            return false;
        }
        if (neededCalories[2] < inventoryProteinCalories) {
            return false;
        }
        if (neededCalories[3] < inventoryOtherCalories) {
            return false;
        }
        return true;
    }

    /**
     * Removes items that are in hamperContents from inventory
     * @param hamperContents The food items to remove from inventory
     * @return True if was able to remove all the items from inventory.
     * False if unable to remove all items from inventory. 
     * This is most likely due to the fact that inventory didn't have at least one item in hamperContents
     * Another reason is all elemenents of hamperContents weren't removed from inventory
     */
    public static boolean removeHamper(ArrayList<String[]> hamperContents) {
        toBeRemoved = new ArrayList<>(hamperContents);
        // Check if all elements of hamperContents are in inventory
        if (!inventory.containsAll(hamperContents)) {
            return false;
        }
        inventory.removeAll(hamperContents);
        
        //Now check if all elements are removed from inventory
        Iterator<String[]> hamperIterator = hamperContents.iterator();
        while (hamperIterator.hasNext()) {
            if (inventory.contains(hamperIterator.next())) {
                // If inventory still has at least 1 food item from hamperContents, 
                // it means all elements weren't removed
                return false;
            }
        }
        return true;
    }

    //Getters and Setters

    public static ArrayList<String[]> getInventory() {
        return inventory;
    }

    public static void setInventory(ArrayList<String[]> inventory) {
        FoodInventory.inventory = inventory;
    }

    public static double getInventoryProteinCalories() {
        return inventoryProteinCalories;
    }

    public static void setInventoryProteinCalories(double inventoryProteinCalories) {
        FoodInventory.inventoryProteinCalories = inventoryProteinCalories;
    }

    public static double getInventoryVeggieCalories() {
        return inventoryVeggieCalories;
    }

    public static void setInventoryVeggieCalories(double inventoryVeggieCalories) {
        FoodInventory.inventoryVeggieCalories = inventoryVeggieCalories;
    }

    public static double getInventoryGrainCalories() {
        return inventoryGrainCalories;
    }

    public static void setInventoryGrainCalories(double inventoryGrainCalories) {
        FoodInventory.inventoryGrainCalories = inventoryGrainCalories;
    }

    public static double getInventoryOtherCalories() {
        return inventoryOtherCalories;
    }

    public static void setInventoryOtherCalories(double inventoryOtherCalories) {
        FoodInventory.inventoryOtherCalories = inventoryOtherCalories;
    }    
}
