package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <h1>DatabaseReader</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.4
 * @since 1.0
 */
public class DatabaseReader {
    private static Connection connection = null;

    /**
     * Initializes conncetion to food_inventory database
     * @return True if connection was successful. False if an SQL exception thrown.
     */
    public static boolean initializeConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory","student","ensf");  // changed from student
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Closes the connection to food_inventory database
     * @return True if connection was closed. False if an SQL exception was thrown.
     */
    public static boolean close() {
        try {
            connection.close();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    // Getter for connection
    public static Connection getConnection() { return connection; }

    /**
     * Reads the daily client needs from the data base and returns the weekly client needs.
     * This means multiply the Calories column by 7. The other numerical fields as kept as percents.
     * @return An ArrayList<Double[]> in which each each Double[] contains all the info 
     * for the weekly needs of a client type
     * @throws SQLException During accessing of database, SQLException may be thrown
     */
    public static ArrayList<Double[]> readWeeklyClientNeeds() throws SQLException{
        ArrayList<Double[]> weeklyClientNeeds = new ArrayList<>();
        Statement readClientNeeds = connection.createStatement();
        ResultSet dailyClientNeeds = readClientNeeds.executeQuery("SELECT * FROM daily_client_needs");
        while (dailyClientNeeds.next()) {
            // Code assumes column index of values are correct
            // Moving columns around will break the code
            double dailyGrain = dailyClientNeeds.getDouble(3);
            double dailyVeggie = dailyClientNeeds.getDouble(4);
            double dailyProtein = dailyClientNeeds.getDouble(5);
            double dailyOther = dailyClientNeeds.getDouble(6);
            double dailyCalorie = dailyClientNeeds.getDouble(7);
            Double[] weeklyNeed = {dailyGrain, dailyVeggie, dailyProtein, 
            dailyOther, dailyCalorie*7};
            // Multiply calories by 7 as calories given is a per day
            // other values not multiplied as those are percents
            weeklyClientNeeds.add(weeklyNeed);
        }
        return weeklyClientNeeds;
    }

    /**
     * Reads the food inventory from the data base and returns the food inventory.
     * All percent information from the inventory have been calculated to a caloric value.
     * @return An ArrayList<String[]> that contains the entire food inventory from the database.
     * Each String[] is a single item, with all its field in order :
     * ItemID, Name, GrainContent, FVContent, ProContent, Other, Calories
     * @exception SQLException During accessing of database, SQLException may be thrown
     */
    public static ArrayList<String[]> readInventory() throws SQLException{
        ArrayList<String[]> inventory = new ArrayList<>();
        Statement readFood = connection.createStatement();
        ResultSet availableFood = readFood.executeQuery("SELECT * FROM available_food");
        while (availableFood.next()) {
            // Code assumes column index of values are correct
            // Moving columns around in database will break the code
            
            int itemID = availableFood.getInt(1);
            String name = availableFood.getString(2);
            double grainContent = availableFood.getDouble(3);
            double fvContent = availableFood.getDouble(4);
            double proContent = availableFood.getDouble(5);
            double other = availableFood.getDouble(6);
            double calorie = availableFood.getDouble(7);

            // Now calculate all caloric value of percents
            grainContent = (grainContent/100)*calorie;
            fvContent = (fvContent/100)*calorie;
            proContent = (proContent/100)*calorie;
            other = (other/100)*calorie;

            // Add to ArrayList
            String[] foodItem = {Integer.toString(itemID), name, 
                Double.toString(grainContent), Double.toString(fvContent), 
                Double.toString(proContent), Double.toString(other),
                Double.toString(calorie)};
            
            inventory.add(foodItem);
        }
        return inventory;
    }

    /**
     * Deletes a food item from the database
     * @param itemID The ID of the food item to delete
     * @return 1 if the item was deleted. 0 if nothing was deleted. 
     * (this may be due to the fact the itemID provided is not part of the database)
     * @throws SQLException During accessing of database, SQLException may be thrown 
     */
    public static int deleteFoodItem(int itemID) throws SQLException{
        Statement deleteFood = connection.createStatement();
        String query = String.format("DELETE FROM available_food WHERE ItemID=%d", itemID);
        return deleteFood.executeUpdate(query);
        // Maybe give it ability to delete more than 1 at once
        // Suppose given an array of ints, and loops through deleting each one at a time
        // calling this function
    }

    // Below a main to test the static methods of this class
    // public static void main(String[] args) throws SQLException{
    //     /*
    //     DatabaseReader.initializeConnection();
        
    //     ArrayList<String[]> needs = DatabaseReader.readWeeklyClientNeeds();
    //     Iterator<String[]> needsIterator= needs.iterator();
    //     while (needsIterator.hasNext()) {
    //         String[] info = needsIterator.next();
    //         for (String s : info) {
    //             System.out.print(s + '\t');
    //         }
    //         System.out.println();
    //     }
    //     // readWeeklyClientNeeds() works as intended.
        
    //     ArrayList<String[]> foods = DatabaseReader.readInventory();
    //     Iterator<String[]> foodsIterator= foods.iterator();
    //     while (foodsIterator.hasNext()) {
    //         String[] info = foodsIterator.next();
    //         for (String s : info) {
    //             System.out.print(s + '\t');
    //         }
    //         System.out.println();
    //     }
    //     // readInventory() works as intended.
        
    //     DatabaseReader.deleteFoodItem(1000);
    //     //deleteFoodItem() works as intended
    //     */
    //     DatabaseReader.close();
    // }
}