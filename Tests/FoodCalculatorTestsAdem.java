package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;

public class FoodCalculatorTestsAdem {
    
    @Test
    public void foodCalculatorConstructorTest() {
        
        FoodCalculator food = new FoodCalculator(1, 1, 2, 0);
        
        int expectedAdultMales = 1;
        int expectedAdultFemales = 1;
        int expectedChildrenU8 = 2;
        int expectedChildrenO8 = 1;
        
        int actualAdultMales = food.getNumAdultMales();
        int actualAdultFemales = food.getNumAdultFemales();
        int actualChildrenU8 = food.getNumChildrenU8();
        int actualChildrenO8 = food.getNumChildrenO8();
        
        assertEquals("Constructor did not properly set NumAdultMales", expectedAdultMales, actualAdultMales);
        assertEquals("Constructor did not properly set NumAdultFemales", expectedAdultFemales, actualAdultFemales);
        assertEquals("Constructor did not properly set NumChildrenU8", expectedChildrenU8, actualChildrenU8);
        assertEquals("Constructor did not properly set NumChildrenO8", expectedChildrenO8, actualChildrenO8);
    }
    
    @Test 
    public void CalculateCaloriesTest() {
        
        FoodCalculator food = new FoodCalculator(1, 0, 1, 1);
        
        double expectedTotalCalories = 42700; //Calculated by hand from data base info
        double expectedWholeGrainCalories = 8092;
        double expectedFruitsVeggiesCalories = 13216;
        double expectedProteinCalories = 12362;
        double expectedOtherCalories = 9030;

        double actualTotalCalories = food.getTotalCalories();
        double actualWholeGrainCalories = food.getWholeGrainCalories();
        double actualFruitsVeggiesCalories = food.getFruitsVeggiesCalories();
        double actualProteinCalories = food.getProteinCalories();
        double actualOtherCalories = food.getOtherCalories();
        
        assertEquals("Total number of calories was not calculated successfully", expectedTotalCalories, actualTotalCalories);
        assertEquals("Number of calories from whole grain foods was not calculated successfully", expectedWholeGrainCalories, actualWholeGrainCalories);
        assertEquals("Number of calories from fruits and veggies was not calculated successfully", expectedFruitsVeggiesCalories, actualFruitsVeggiesCalories);
        assertEquals("Number of calories from proteins was not calculated successfully", expectedProteinCalories, actualProteinCalories);
        assertEquals("Number of calories from other calorie sources was not calculated successfully", expectedOtherCalories, actualOtherCalories);
    }
}
