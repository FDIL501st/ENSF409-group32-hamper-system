package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @since 1.0
 * @version 1.2
 */
public class DatabaseReader {
    private static Connection connection = null;

    /**
     * Initializes conncetion to food_inventory database
     * @return True if connection was successful. False if an SQL exception thrown.
     */
    public static boolean initializeConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/food_inventory","student","ensf");
        } catch (SQLException e) {
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
     * Returns the weekly client needs from the database
     * @return An ArrayList<String[]> in which each each String[] contains all the info 
     * for the weekly needs of a client type
     * @throws SQLException During accessing of database, SQLException may be thrown
     */
    public static ArrayList<String[]> getWeeklyClientNeeds() throws SQLException{
        ArrayList<String[]> weeklyClientNeeds = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet dailyClientNeeds = statement.executeQuery("SELECT * FROM daily_client_needs");
        while (dailyClientNeeds.next()) {
            // Code assumes column index of values are correct
            // Moving columns around will break the code
            String clientType =  dailyClientNeeds.getString(2);
            String dailyGrain = dailyClientNeeds.getString(3);
            String dailyVeggie = dailyClientNeeds.getString(4);
            String dailyProtein = dailyClientNeeds.getString(5);
            String dailyOther = dailyClientNeeds.getString(6);
            double dailyCalorie = dailyClientNeeds.getDouble(7);
            String[] weeklyNeed = {clientType, dailyGrain, dailyVeggie, dailyProtein, 
            dailyOther, Double.toString(dailyCalorie*7)};
            // Multiply calories by 7 as calories given is a per day
            // other values not multiplied as those are percents
            weeklyClientNeeds.add(weeklyNeed);
        }
        return weeklyClientNeeds;
    }

    // Below a main to test the static methods of this class
    public static void main(String[] args) throws SQLException{
        DatabaseReader.initializeConnection();
        ArrayList<String[]> needs = DatabaseReader.getWeeklyClientNeeds();
        Iterator<String[]> needsIterator= needs.iterator();
        while (needsIterator.hasNext()) {
            String[] info = needsIterator.next();
            for (String s : info) {
                System.out.print(s + '\t');
            }
            System.out.println();
        }
        // getWeeklyClientNeeds() works as intended.


        DatabaseReader.close();
    }
}
