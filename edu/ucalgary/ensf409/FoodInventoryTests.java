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
        ArrayList<String[]> expectedFoods = new ArrayList<String[]>();
        String[] apple = {"1", "Apples", "0", "60", "10", "30", "10"};
        String[] chicken = {"2", "Chicken", "10", "0", "50", "40", "10"};
        String[] pie = {"3", "Pie", "30", "40", "10", "20", "10"};
        String[] yam = {"4", "Yam", "40", "50", "10", "0", "10"};
        expectedFoods.add(apple);
        expectedFoods.add(chicken);
        expectedFoods.add(pie);
        expectedFoods.add(yam);
    
        inventory.setInventory(expectedFoods);
        ArrayList<String[]> actualFoods = FoodInventory.getInventory();
        assertEquals("getInventory did not return the correct values", expectedFoods, actualFoods);
    }
    
    // Test that the readDataBaseInventory functions return true indicating successful read of database
    @Test
    public void readDatabaseInventoryTest(){
        DatabaseReader.initializeConnection();
        FoodInventory inventory = new FoodInventory();
        boolean expected = true;
        boolean actual = inventory.readDatabaseInventory();
        DatabaseReader.close();
        assertEquals("readDatabaseInventory did not return the correct boolean value", expected, actual);
    }
    
    // Test that updateDatabaseTest return true indicating successful update of databases
    @Test
    public void updateDatabaseTest(){
        DatabaseReader.initializeConnection();
        FoodInventory inventory = new FoodInventory();
        boolean expected = true;
        boolean actual = inventory.updateDatabase();
        DatabaseReader.close();
        assertEquals("updateDatabase did not return the correct boolean value", expected, actual);
    }
    
    // Test that checkShortageTest returns true when there is a shortage
    @Test
    public void checkShortageTest(){
        // Create a foodCombo of one item
        ArrayList<String[]> expectedFoods = new ArrayList<>();
        String[] foodItem = new String[7];
        foodItem[0] = "10";
        foodItem[1] = "testFood";
        foodItem[2] = "20";
        foodItem[3] = "13";
        foodItem[4] = "50";
        foodItem[5] = "50";
        foodItem[6] = "100";
        expectedFoods.add(foodItem);
        FoodInventory.setInventory(expectedFoods);
        double[] neededCalories = {10.1, 11, 23, 45, 56};
        boolean actual = FoodInventory.checkShortage(neededCalories);
    
        assertTrue("checkShortageTest did not return true.",actual);
    }
    
    // Test the getters and setters of FoodInventory
    @Test
    public void setInventoryCaloriesTest(){
        double expectedInventoryProteinCals = 23010;
        double expectedInventoryVeggieCals = 9820;
        double expectedInventoryGrainCals = 12000;
        double expectedInventoryOtherCals = 34200;
    
        FoodInventory inventory = new FoodInventory();
        inventory.setInventoryProteinCalories(expectedInventoryProteinCals);
        inventory.setInventoryVeggieCalories(expectedInventoryVeggieCals);
        inventory.setInventoryGrainCalories(expectedInventoryGrainCals);
        inventory.setInventoryOtherCalories(expectedInventoryOtherCals);
    
        double actualInventoryProteinCals = inventory.getInventoryProteinCalories();
        double actualInventoryVeggieCals = inventory.getInventoryVeggieCalories();
        double actualInventoryGrainCals = inventory.getInventoryGrainCalories();
        double actualInventoryOtherCals = inventory.getInventoryOtherCalories();
    
        assertEquals("Incorrect number of Protein Calories", expectedInventoryProteinCals, actualInventoryProteinCals, 0.001);
        assertEquals("Incorrect number of Veggie Calories", expectedInventoryVeggieCals, actualInventoryVeggieCals, 0.001);
        assertEquals("Incorrect number of Grain Calories", expectedInventoryGrainCals, actualInventoryGrainCals, 0.001);
        assertEquals("Incorrect number of Other Calories", expectedInventoryOtherCals, actualInventoryOtherCals, 0.001);
    }

    @Test
    public void RemoveHamperTest() {
        // Tests to see if item actually removed from inventory and moved to toBeRemoved
        FoodInventory foodInventory = new FoodInventory();
        
        ArrayList<String[]> newInventory = new ArrayList<>();
        String[] add1 = {"10", "Lettuce", "33", "1", "33", "1", "1000"};
        String[] add2 = {"11", "Cake", "22", "12", "33", "22", "332"};
        String[] add3 = {"12", "Bread", "21", "21", "44", "12", "414"};
        String[] add4 = {"13", "Lettuce", "33", "1", "33", "1", "1000"};
        String[] add5 = {"14", "Lettuce", "33", "1", "33", "1", "1000"};
        String[] add6 = {"15", "Cake", "22", "12", "33", "22", "332"};
        String[] add7 = {"16", "Cake", "22", "12", "33", "22", "332"};
        newInventory.add(add1);
        newInventory.add(add2);
        newInventory.add(add3);
        newInventory.add(add4);
        newInventory.add(add5);
        newInventory.add(add6);
        newInventory.add(add7);
        foodInventory.setInventory(newInventory);

        ArrayList<String[]> toRemove = new ArrayList<>();
        toRemove.add(add3);
        toRemove.add(add7);
        foodInventory.removeHamper(toRemove);
        
        ArrayList<String[]> expected = (ArrayList<String[]>) newInventory.clone();
        expected.removeAll(toRemove);

        assertArrayEquals(expected.toArray(), foodInventory.getInventory().toArray());
    }
}
