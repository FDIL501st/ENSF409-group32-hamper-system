package Tests;

import edu.ucalgary.ensf409.*;
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.*;

public class FoodInventoryTestsTanvir {
@Test
public void setInventoryTest(){
    // Test setInventory and getInventory 
    FoodInventory inventory = new FoodInventory();
    ArrayList<String[]> expectedFoods = new ArrayList<>();
    String[] add1 = {"0", "Apples", "5", "4", "2", "100"};
    String[] add2 = {"1", "Milk", "23", "44", "44", "32", "1000"};
    String[] add3 = {"2", "Pizza", "33", "45", "33", "2", "5000"};
    expectedFoods.add(add1);
    expectedFoods.add(add2);
    expectedFoods.add(add3);

    inventory.setInventory(expectedFoods);
    ArrayList<String[]> actualFoods = inventory.getInventory();
    assertEquals("getInventory did not return the correct values", expectedFoods, actualFoods);
}

// Are these ok like this, or should we exclude?
// They are ok to keep

@Test
public void readDatabaseInventoryTest(){
    // Test that the readDataBaseInventory functions return true indicating successful read of database
    FoodInventory inventory = new FoodInventory();
    boolean expected = true;
    boolean actual = inventory.readDatabaseInventory();
    assertEquals("readDatabaseInventory did not return the correct boolean value", expected, actual);
}

@Test
public void updateDatabaseTest(){
    // Test that updateDatabaseTest return true indicating successful update of databases
    FoodInventory inventory = new FoodInventory();
    boolean expected = true;
    boolean actual = inventory.updateDatabase();
    assertEquals("updateDatabase did not return the correct boolean value", expected, actual);
}


public void checkShortageTest(){
    // Test that checkShortageTest returns true when there is a shortage
    FoodInventory inventory = new FoodInventory();
    ArrayList<String[]> expectedFoods = new ArrayList<>();
    expectedFoods.clear();
    inventory.setInventory(expectedFoods);

    boolean expected = true;
    boolean actual = inventory.checkShortage();

    assertEquals("checkShortageTest did not return the correct boolean value", expected, actual);
}

public void setInventoryCaloriesTest(){
    // Test the getters and setters of FoodInventory
    int expectedInventoryProteinCals = 23010;
    int expectedInventoryVeggieCals = 9820;
    int expectedInventoryGrainCals = 12000;
    int expectedInventoryOtherCals = 34200;

    FoodInventory inventory = new FoodInventory();
    inventory.setInventoryProteinCalories(expectedInventoryProteinCals);
    inventory.setInventoryVeggieCalories(expectedInventoryVeggieCals);
    inventory.setInventoryGrainCalories(expectedInventoryGrainCals);
    inventory.setInventoryOtherCalories(expectedInventoryOtherCals);

    int actualInventoryProteinCals = inventory.getInventoryProteinCalories();
    int actualInventoryVeggieCals = inventory.getInventoryVeggieCalories();
    int actualInventoryGrainCals = inventory.getInventoryGrainCalories();
    int actualInventoryOtherCals = inventory.getInventoryOtherCalories();

    assertEquals("Incorrect number of Protein Calories", expectedInventoryProteinCals, actualInventoryProteinCals);
    assertEquals("Incorrect number of Veggie Calories", expectedInventoryVeggieCals, actualInventoryVeggieCals);
    assertEquals("Incorrect number of Grain Calories", expectedInventoryGrainCals, actualInventoryGrainCals);
    assertEquals("Incorrect number of Other Calories", expectedInventoryOtherCals, actualInventoryOtherCals);
}
@Test
public void RemoveHaperTest() {
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
