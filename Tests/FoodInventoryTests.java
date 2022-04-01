package Tests;

import edu.ucalgary.ensf409.*;
import java.util.ArrayList;
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

    @Test
    public void InventorySetterGetterTest() {
        ArrayList<String> expected = new ArrayList<>();
        expected.add("Canned Apples");
        expected.add("Oranges");
        expected.add("Cereal");
        
        foodInventory.setInventory(expected);
        ArrayList<String> actual = foodInventory.getInventory();

        assertEquals("Expected an ArrayList<String> with [Canned Apples, Oranges, Cereal]", expected, actual);
    }

    @Test
    public void checkShortageFalseTest() {
        ArrayList<String> newInventory = new ArrayList<>();
        newInventory.add("Canned Apples");
        newInventory.add("Oranges");
        newInventory.add("Cereal");
        newInventory.add("Avacado");
        newInventory.add("Canned Pineapples");
        newInventory.add("Cake");
        newInventory.add("Sliced Cheese");
        newInventory.add("Bread");
        newInventory.add("Pears"); 
        newInventory.add("Frozen Spinach"); 
        newInventory.add("Lettuce");

        foodInventory.setInventory(newInventory);

        boolean actual = foodInventory.checkShortage();
        assertFalse("Expected to have no shortage.", actual);
    }

    @Test
    public void checkShortageTrueTest() {
        ArrayList<String> newInventory = new ArrayList<>();
        foodInventory.setInventory(newInventory);

        boolean actual = foodInventory.checkShortage();
        assertTrue("Expected there to be a shortage.", actual);
    }
}
