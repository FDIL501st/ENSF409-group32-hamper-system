package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/* Tests for the FoodInventory Class */

public class FoodInventoryTests{

    // Test setInventory and getInventory 
    @Test
    public void setInventoryTest(){
        FoodInventory inventory = new FoodInventory();
        ArrayList<String> expectedFoods = new ArrayList<>();
        expectedFoods.add("Apples");
        expectedFoods.add("Milk");
        expectedFoods.add("Pizza");
    
        inventory.setInventory(foods);
        Arraylist<String> actualFoods = getInventory();
        assertEquals("getInventory did not return the correct values", expectedFoods, actualFoods);
    }
    
    // Test that the readDataBaseInventory functions return true indicating successful read of database
    @Test
    public void readDatabaseInventoryTest(){
        FoodInventory inventory = new FoodInventory();
        boolean expected = true;
        boolean actual = inventory.readDatabaseInventory();
        assertEquals("readDatabaseInventory did not return the correct boolean value", expected, actual);
    }
    
    // Test that updateDatabaseTest return true indicating successful update of databases
    @Test
    public void updateDatabaseTest(){
        FoodInventory inventory = new FoodInventory();
        boolean expected = true;
        boolean actual = inventory.updateDatabase();
        assertEquals("updateDatabase did not return the correct boolean value", expected, actual);
    }
    
    // Test that checkShortageTest returns true when there is a shortage
    @Test
    public void checkShortageTest(){
        FoodInventory inventory = new FoodInventory();
        ArrayList<String> expectedFoods = new ArrayList<>();
        inventory.setInventory();
    
        boolean expected = true;
        boolean actual = inventory.checkShortage();
    
        assertEquals("checkShortageTest did not return the correct boolean value", expected, actual);
    }
    
    // Test the getters and setters of FoodInventory
    @Test
    public void setInventoryCaloriesTest(){
        int expectedInventoryProteinCals = 23010;
        int expectedInventoryVeggieCals = 9820;
        int expectedInventoryGrainCals = 12000;
        int expectedInventoryOtherCals = 34200;
    
        FoodInventory inventory = new FoodInventory();
        inventory.setInventoryProteinCalories(expectedInventoryProteinCals);
        inventory.setInventoryVeggieCalories(expectedInventoryVeggieCals);
        inventory.setInventoryGrainCalories(expectedInventoryGrainCals);
        inventory.setInventoryOtheralories(expectedInventoryOtherCals);
    
        int actualInventoryProteinCals = inventory.getInventoryProteinCalories();
        int actualInventoryVeggieCals = inventory.getInventoryVeggieCalories();
        int actualInventoryGrainCals = inventory.getInventoryGrainalories();
        int actualInventoryOtherCals = inventory.getInventoryOtherCalories();
    
        assertEquals("Incorrect number of Protein Calories", expectedInventoryProteinCals, actualInventoryProteinCals);
        assertEquals("Incorrect number of Veggie Calories", expectedInventoryVeggieCals, actualInventoryVeggieCals);
        assertEquals("Incorrect number of Grain Calories", expectedInventoryGrainCals, actualInventoryGrainCals);
        assertEquals("Incorrect number of Other Calories", expectedInventoryOtherCals, actualInventoryOtherCals);
    }
}