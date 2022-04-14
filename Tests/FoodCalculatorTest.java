/**
 * <h1>FoodCalculatorTest</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.3
 * @since 1.0
 */

package Tests;
import edu.ucalgary.ensf409.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class FoodCalculatorTest{	
	
	final int ADULTMALES = 1;
	final int ADULTFEMALES = 1;
	final int CHILDU8 = 1;
	final int CHILDO8 = 1;
		
	// Expected calorie values for each type of person.
	final double ADULTMALE_GRAIN_CALORIES = 2800.0;
	final double ADULTMALE_VEGGIE_CALORIES = 4900.0;
	final double ADULTMALE_PROTEIN_CALORIES = 4550.0;
	final double ADULTMALE_OTHER_CALORIES = 5250.0;
	final double ADULTMALE_TOTAL_CALORIES = 17500.0;
	
	final double ADULTFEMALE_GRAIN_CALORIES = 2240.0;
	final double ADULTFEMALE_VEGGIE_CALORIES = 3920.0;
	final double ADULTFEMALE_PROTEIN_CALORIES = 3640.0;
	final double ADULTFEMALE_OTHER_CALORIES = 4200.0;
	final double ADULTFEMALE_TOTAL_CALORIES = 14000.0;
	
	final double CHILDU8_GRAIN_CALORIES = 2058.0;
	final double CHILDU8_VEGGIE_CALORIES = 3234.0;
	final double CHILDU8_PROTEIN_CALORIES = 3038.0;
	final double CHILDU8_OTHER_CALORIES = 1470.0;
	final double CHILDU8_TOTAL_CALORIES = 9800.0;
	
	final double CHILDO8_GRAIN_CALORIES = 3234.0;
	final double CHILDO8_VEGGIE_CALORIES = 5082.0;
	final double CHILDO8_PROTEIN_CALORIES = 4774.0;
	final double CHILDO8_OTHER_CALORIES = 2310.0;
	final double CHILDO8_TOTAL_CALORIES = 15400.0;
	
	@Test 
	public void testAllPossibleCombos() {
		FoodCalculator foodCalculator = new FoodCalculator(0, 0, 0, 0);
		ArrayList<String[]> sampleDatabase = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "60", "10", "30", "10"};
		sampleDatabase.add(add1);
		String[] add2 = {"2", "Chicken", "10", "0", "50", "40", "10"};
		sampleDatabase.add(add2);
		String[] add3 = {"3", "Pie", "30", "40", "10", "20", "10"};
		sampleDatabase.add(add3);
		String[] add4 = {"4", "Yam", "40", "50", "10", "0", "10"};
		sampleDatabase.add(add4);
		String[] add5 = {"5", "Apples", "0", "60", "10", "30", "10"};
		sampleDatabase.add(add5);
		String[] add6 = {"6", "Chicken", "10", "0", "50", "40", "10"};
		sampleDatabase.add(add6);
		String[] add7 = {"7", "Pie", "30", "40", "10", "20", "10"}; 
		sampleDatabase.add(add7);
		String[] add8 = {"8", "Yam", "40", "50", "10", "0", "10"};
		sampleDatabase.add(add8);
		String[] add9 = {"9", "Gum", "30", "30", "30", "10", "100"};
		sampleDatabase.add(add9);
		ArrayList<ArrayList<String[]>> allCombos = foodCalculator.allPossibleCombos(sampleDatabase);
		int expectedSize = 512;
		int actualSize = allCombos.size();

		assertEquals(expectedSize, actualSize);
	}
	@Test
	public void testFoodCalculatorGettersSam(){
		
		//// Setting up variables for testing.
		
		// Create a new hamper object
		Hamper myHamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
		
		// Setup an array of one hamper.
		Hamper[] hamperArr = { myHamper };
		
		// Create HamperRequest object for testing. Is this even necessary?
		HamperRequest myRequest = new HamperRequest(hamperArr);
		
		// Grab the FoodCalculator reference for testing.
		
		FoodCalculator foodCalcReference = myRequest.getHampers().get(0).getFoodCalculator();
		
		// Calculate expected values for each calorie variable.
		
		double expectedWholeGrainCalories = ((double)ADULTMALES)* ADULTMALE_GRAIN_CALORIES + ((double)ADULTFEMALES)* ADULTFEMALE_GRAIN_CALORIES + ((double)CHILDU8)* CHILDU8_GRAIN_CALORIES + ((double)CHILDO8)* CHILDO8_GRAIN_CALORIES;
		double expectedFruitsVeggiesCalories = ((double)ADULTMALES)* ADULTMALE_VEGGIE_CALORIES + ((double)ADULTFEMALES)* ADULTFEMALE_VEGGIE_CALORIES + ((double)CHILDU8)* CHILDU8_VEGGIE_CALORIES + ((double)CHILDO8)* CHILDO8_VEGGIE_CALORIES;
		double expectedProteinCalories = ((double)ADULTMALES)* ADULTMALE_PROTEIN_CALORIES + ((double)ADULTFEMALES)* ADULTFEMALE_PROTEIN_CALORIES + ((double)CHILDU8)* CHILDU8_PROTEIN_CALORIES + ((double)CHILDO8)* CHILDO8_PROTEIN_CALORIES;
		double expectedOtherCalories = ((double)ADULTMALES)* ADULTMALE_OTHER_CALORIES + ((double)ADULTFEMALES)* ADULTFEMALE_OTHER_CALORIES + ((double)CHILDU8)* CHILDU8_OTHER_CALORIES + ((double)CHILDO8)* CHILDO8_OTHER_CALORIES;
		double expectedTotalCalories = ((double)ADULTMALES)* ADULTMALE_TOTAL_CALORIES + ((double)ADULTFEMALES)* ADULTFEMALE_TOTAL_CALORIES + ((double)CHILDU8)* CHILDU8_TOTAL_CALORIES + ((double)CHILDO8)* CHILDO8_TOTAL_CALORIES;
		
		//// Testing Getters.
		
		
		double actualWholeGrainCalories = foodCalcReference.getWholeGrainCalories();
		double actualFruitsVeggiesCalories = foodCalcReference.getFruitsVeggiesCalories();
		double actualProteinCalories = foodCalcReference.getProteinCalories();
		double actualOtherCalories = foodCalcReference.getOtherCalories();
		double actualTotalCalories = foodCalcReference.getTotalCalories();
		int actualAdultMales = foodCalcReference.getNumAdultMales();
		int actualAdultFemales = foodCalcReference.getNumAdultFemales();
		int actualChildU8 = foodCalcReference.getNumChildrenU8();
		int actualChildO8 = foodCalcReference.getNumChildrenO8();
		
		assertEquals("Value of Whole Grain Calories did not match what was expected", expectedWholeGrainCalories, actualWholeGrainCalories);
		assertEquals("Value of Fruits Veggies Calories did not match what was expected", expectedFruitsVeggiesCalories, actualFruitsVeggiesCalories);
		assertEquals("Value of Protein Calories did not match what was expected", expectedProteinCalories, actualProteinCalories);
		assertEquals("Value of Other Calories did not match what was expected", expectedOtherCalories, actualOtherCalories);
		assertEquals("Value of Total Calories did not match what was expected", expectedTotalCalories, actualTotalCalories);
		assertEquals("Value of Adult Males did not match what was expected", ADULTMALES, actualAdultMales);
		assertEquals("Value of Adult Females did not match what was expected", ADULTFEMALES, actualAdultFemales);
		assertEquals("Value of Child Under 8 did not match what was expected", CHILDU8, actualChildU8);
		assertEquals("Value of Child Over 8 did not match what was expected", CHILDO8, actualChildO8);
		
	}
	
	@Test
    	public void foodCalculatorConstructorTest() {

		FoodCalculator food = new FoodCalculator(1, 1, 2, 1);

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

		assertEquals("Total number of calories was not calculated successfully", expectedTotalCalories, actualTotalCalories, 0.001);
		assertEquals("Number of calories from whole grain foods was not calculated successfully", expectedWholeGrainCalories, actualWholeGrainCalories, 0.001);
		assertEquals("Number of calories from fruits and veggies was not calculated successfully", expectedFruitsVeggiesCalories, actualFruitsVeggiesCalories, 0.001);
		assertEquals("Number of calories from proteins was not calculated successfully", expectedProteinCalories, actualProteinCalories, 0.001);
		assertEquals("Number of calories from other calorie sources was not calculated successfully", expectedOtherCalories, actualOtherCalories, 0.001);
    	}
	
}
