package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <h1>FoodInventory</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem Soufi <a href="mailto:adem.soufi@ucalgary.ca">adem.soufi@ucalgary.ca</a> | UCID: 30101252
 * @author Fadil Husain <a href="mailto:fadil.husain@ucalgary.ca">fadil.husain@ucalgary.ca</a> | UCID: 30113409
 * @author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a> | UCID: 30092208
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 1.7
 * @since 1.0
 */

public class FoodInventory {

    // Member Variables
    private static ArrayList<String[]> inventory = new ArrayList<>();
    private static ArrayList<String[]> toBeRemoved = new ArrayList<>();
    private static double inventoryProteinCalories;
    private static double inventoryVeggieCalories;
    private static double inventoryGrainCalories;
    private static double inventoryOtherCalories;
    private static String shortageMessage = "";

    /**
     * Constructor causes the class to sync up with the available_food database
     */
    public FoodInventory() {
        // Constructor is like a reset, used to first set up the FoodInventory class
        // or reset it
        
        // Initialize inventory
        readDatabaseInventory();
        // Calculate inventory calories from inventory
        calculateInventoryCalories();
        //Also initialize client info
        ArrayList<Double[]> clientNeeds = new ArrayList<>();
        try {
            clientNeeds = DatabaseReader.readWeeklyClientNeeds();
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        Double[] aMInfo = clientNeeds.get(0);
        Double[] aFInfo = clientNeeds.get(1);
        Double[] cO8Info = clientNeeds.get(2);
        Double[] cU8Info = clientNeeds.get(3);
        AdultMale adultMale = new AdultMale(aMInfo[0], aMInfo[1], aMInfo[2], aMInfo[3], aMInfo[4]);
        AdultFemale adultFemale = new AdultFemale(aFInfo[0], aFInfo[1], aFInfo[2], aFInfo[3], aFInfo[4]);
        ChildOverEight childOverEight = new ChildOverEight(cO8Info[0], cO8Info[1], cO8Info[2], cO8Info[3], cO8Info[4]);
        ChildUnderEight childUnderEight = new ChildUnderEight(cU8Info[0], cU8Info[1], cU8Info[2], cU8Info[3], cU8Info[4]);
         
    }

    /**
     * Calculates inventory calories
     */
    private static void calculateInventoryCalories() {
        // Initialize inventory calories to 0
        setInventoryGrainCalories(0);
        setInventoryVeggieCalories(0);
        setInventoryProteinCalories(0);
        setInventoryOtherCalories(0);
        // Start adding up 
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
     * Getter for any shortage message
     * @return is a String of the shortage message
     */
    public static String getShortageMessage() {
        return shortageMessage;
    }

    /**
     * Setter for any shortage message
     * @param message is the shortage message
     */
    public static void setShortageMessage(String message) {
        shortageMessage = message;
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
     * Reports details on any shortages.
     * @param neededCalories An array which holds information of how much calories is needed by a hamper.
     * First element should be grain calories needed, second should be fruit and veggie calorie, 
     * third should be protein calorie needed and fourth element should be other calorie needed.
     * @return False if there is no food shortage. This means inventory has enough food for a hamper.
     * True if there is a food shortage. This means inventory does not have enough food for a hamper.
     */
    public static boolean checkShortage(double[] neededCalories) {
        if (neededCalories[0] > inventoryGrainCalories) {
            double defecit = neededCalories[0] - inventoryGrainCalories;
            setShortageMessage("Missing " + String.format("%.0f", defecit) + " grain calories.");
            return true;
        }
        if (neededCalories[1] > inventoryVeggieCalories) {
            double defecit = neededCalories[1] - inventoryVeggieCalories;
            setShortageMessage("Missing " + String.format("%.0f", defecit) + " fruits and veggie calories.");
            return true;
        }
        if (neededCalories[2] > inventoryProteinCalories) {
            double defecit = neededCalories[2] - inventoryProteinCalories;
            setShortageMessage("Missing " + String.format("%.0f", defecit) + " protein calories.");
            return true;
        }
        if (neededCalories[3] > inventoryOtherCalories) {
            double defecit = neededCalories[3] - inventoryOtherCalories;
            setShortageMessage("Missing " + String.format("%.0f", defecit) + " other calories.");
            return true;
        }
        return false;
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
        toBeRemoved.addAll(hamperContents);
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
        calculateInventoryCalories();
        // recalculate calories of inventory
        return true;
    }

    /**
     * Restores food items that were removed in inventory.
     * Also clears out toBeRemoved
     * @return True if all food items were restored. False if not.
     * @implSpec This should be called in case of a shortage before updating database.
     * Ensure no food items not used are lost. 
     * Alternate function to use from updateDatabase().
     */
    public static boolean restoreInventory() {
        inventory.addAll(toBeRemoved);
        if (inventory.containsAll(toBeRemoved)) {
            // clear toBeRemoved as no longer needed
            toBeRemoved.clear();

            calculateInventoryCalories();
            // recalculate calories of inventory
            return true;
        }
        return false;
    }

    //Getters and Setters

    /**
     * Getter for the current food inventory
     * @return an ArrayList of String arrays containinig the current inventory
     */
    public static ArrayList<String[]> getInventory() {
        return inventory;
    }

    /**
     * Setter for the food inventory
     * @param inventory is the current food inventory available
     */
    public static void setInventory(ArrayList<String[]> inventory) {
        FoodInventory.inventory = inventory;
        calculateInventoryCalories();
    }

    /**
     * Getter for the protein calories in the inventory
     * @return double value of the protein calories in the inventory
     */
    public static double getInventoryProteinCalories() {
        return inventoryProteinCalories;
    }

    /**
     * Setter for the inventory protein calories
     * @param inventoryProteinCalories is the protein calories available in the inventory
     */
    public static void setInventoryProteinCalories(double inventoryProteinCalories) {
        FoodInventory.inventoryProteinCalories = inventoryProteinCalories;
    }

    /**
     * Getter for the fruits and veggie calories in the inventory
     * @return double value of the fruits and veggies calories in the inventory
     */
    public static double getInventoryVeggieCalories() {
        return inventoryVeggieCalories;
    }

    /**
     * Setter for the inventory fruits and veggies calories
     * @param inventoryVeggieCalories is the fruits and veggies calories available in the inventory
     */
    public static void setInventoryVeggieCalories(double inventoryVeggieCalories) {
        FoodInventory.inventoryVeggieCalories = inventoryVeggieCalories;
    }

    /**
     * Getter for the grain calories in the inventory
     * @return double value of the grain calories in the inventory
     */
    public static double getInventoryGrainCalories() {
        return inventoryGrainCalories;
    }

    /**
     * Setter for the inventory grain calories
     * @param inventoryGrainCalories is the grain calories available in the inventory
     */
    public static void setInventoryGrainCalories(double inventoryGrainCalories) {
        FoodInventory.inventoryGrainCalories = inventoryGrainCalories;
    }

    /**
     * Getter for the other calories in the inventory
     * @return double value of the other calories in the inventory
     */
    public static double getInventoryOtherCalories() {
        return inventoryOtherCalories;
    }

    /**
     * Setter for the inventory other calories
     * @param inventoryOtherCalories is the other calories available in the inventory
     */
    public static void setInventoryOtherCalories(double inventoryOtherCalories) {
        FoodInventory.inventoryOtherCalories = inventoryOtherCalories;
    }    
}
