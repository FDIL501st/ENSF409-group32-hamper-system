package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;

public class FoodInventoryTests {
    private FoodInventory foodInventory;

    @Before
    public void setUp() {
        foodInventory = new FoodInventory();
    }

    @Test
    public void FoodInventoryCalorieSettersGettersTest() {
        // Tests all the setters and getters for FoodInventory
        // Does not test get inventory
        int expected = 100;
        foodInventory.setInventoryGrainCalories(expected);
        int actual = foodInventory.getInventoryGrainCalories();
        assertEquals("Expected total grain calories in inventory to be 100.", expected, actual);

        foodInventory.setInventoryOtherCalories(expected);
        actual = foodInventory.getInventoryOtherCalories();
        assertEquals("Expected total other calories in invetory to be 100.", expected, actual);

        foodInventory.setInventoryVeggieCalories(expected);
        actual = foodInventory.getInventoryVeggieCalories();
        assertEquals("Expected total veggie calories in invetory to be 100.", expected, actual);

        foodInventory.setInventoryProteinCalories(expected);
        actual = foodInventory.getInventoryProteinCalories();
        assertEquals("Expected total protein calories in invetory to be 100.", expected, actual);
    }
}
