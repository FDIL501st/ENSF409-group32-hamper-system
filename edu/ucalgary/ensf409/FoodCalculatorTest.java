/**
 * <h1>FoodCalculatorTest</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.3
 * @since 1.0
 */

package edu.ucalgary.ensf409;
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

	@Before
	public void setUp() {
		AdultMale.setGrains(ADULTMALE_GRAIN_CALORIES);
		AdultMale.setVeggies(ADULTMALE_VEGGIE_CALORIES);
		AdultMale.setProteins(ADULTMALE_PROTEIN_CALORIES);
		AdultMale.setOthers(ADULTMALE_OTHER_CALORIES);
		AdultMale.setCalories(ADULTMALE_TOTAL_CALORIES);

		AdultFemale.setGrains(ADULTFEMALE_GRAIN_CALORIES);
		AdultFemale.setVeggies(ADULTFEMALE_VEGGIE_CALORIES);
		AdultFemale.setProteins(ADULTFEMALE_PROTEIN_CALORIES);
		AdultFemale.setOthers(ADULTFEMALE_OTHER_CALORIES);
		AdultFemale.setCalories(ADULTFEMALE_TOTAL_CALORIES);
		
		ChildUnderEight.setGrains(CHILDU8_GRAIN_CALORIES);
		ChildUnderEight.setVeggies(CHILDU8_VEGGIE_CALORIES);
		ChildUnderEight.setProteins(CHILDU8_PROTEIN_CALORIES);
		ChildUnderEight.setOthers(CHILDU8_OTHER_CALORIES);
		ChildUnderEight.setCalories(CHILDU8_TOTAL_CALORIES);
		
		ChildOverEight.setGrains(CHILDO8_GRAIN_CALORIES);
		ChildOverEight.setVeggies(CHILDO8_VEGGIE_CALORIES);
		ChildOverEight.setProteins(CHILDO8_PROTEIN_CALORIES);
		ChildOverEight.setOthers(CHILDO8_OTHER_CALORIES);
		ChildOverEight.setCalories(CHILDO8_TOTAL_CALORIES);
	
	}
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
		FoodInventory.setInventory(sampleDatabase);
		// All 8 possible combos
		ArrayList<String[]> combo1 = new ArrayList<>(1);
		ArrayList<String[]> combo2 = new ArrayList<>(1);
		combo2.add(add1);
		ArrayList<String[]> combo3 = new ArrayList<>(1);
		combo3.add(add2);
		ArrayList<String[]> combo4 = new ArrayList<>(1);
		combo4.add(add3);
		ArrayList<String[]> combo5 = new ArrayList<>(2);
		combo5.add(add2);
		combo5.add(add1);
		ArrayList<String[]> combo6 = new ArrayList<>(2);
		combo6.add(add2);
		combo6.add(add1);
		ArrayList<String[]> combo7 = new ArrayList<>(2);
		combo7.add(add3);
		combo7.add(add2);
		ArrayList<String[]> combo8 = new ArrayList<>(3);
		combo8.add(add3);
		combo8.add(add2);
		combo8.add(add1);
		ArrayList<ArrayList<String[]>> allCombos = new ArrayList<>(8);
		allCombos.add(combo1);
		allCombos.add(combo2);
		allCombos.add(combo3);
		allCombos.add(combo4);
		allCombos.add(combo5);
		allCombos.add(combo6);
		allCombos.add(combo7);
		allCombos.add(combo8);

		ArrayList<ArrayList<String[]>> actualArray = foodCalculator.allPossibleCombos(sampleDatabase);
	
		// If both allCombos and actual have same combos, then if remove all of actual in allCombos, 
		// allCombos should end up as empty
		
		//Issue found is that different ordering of String[] elements can cause the combo to be "different"
		// So made sure that allCombos followed same ordering as code
		allCombos.removeAll(actualArray);
		assertTrue("allCombos should be empty as removed all elements from actual, which should be all of allCombos",
		allCombos.isEmpty());
	}
	
	/**
     	* Testing that the getters in the FoodCalculator class all return the correct values after being initialized in the constructor.
     	*/
	
	@Test
	public void testFoodCalculatorGettersSam(){
		
		// Create Hamper object for testing. 
		Hamper hamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
	
		// Grab the FoodCalculator reference for testing.
		
		FoodCalculator foodCalcReference = hamper.getFoodCalculator();
		
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
		
		assertEquals("Value of Whole Grain Calories did not match what was expected", expectedWholeGrainCalories, actualWholeGrainCalories, 0.001);
		assertEquals("Value of Fruits Veggies Calories did not match what was expected", expectedFruitsVeggiesCalories, actualFruitsVeggiesCalories, 0.001);
		assertEquals("Value of Protein Calories did not match what was expected", expectedProteinCalories, actualProteinCalories, 0.001);
		assertEquals("Value of Other Calories did not match what was expected", expectedOtherCalories, actualOtherCalories, 0.001);
		assertEquals("Value of Total Calories did not match what was expected", expectedTotalCalories, actualTotalCalories, 0.001);
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
    	
	/**
     	* Testing that the calculated calorie values match what is expected.
     	*/
	
    	@Test 
    	public void CalculateCaloriesTest() {

		FoodCalculator food = new FoodCalculator(1, 0, 1, 1);
		// wrong values as should not be from database but from data above
		double expectedTotalCalories = ADULTMALE_TOTAL_CALORIES + CHILDO8_TOTAL_CALORIES + CHILDU8_TOTAL_CALORIES; //Calculated by hand from data base info
		double expectedWholeGrainCalories = ADULTMALE_GRAIN_CALORIES + CHILDO8_GRAIN_CALORIES + CHILDU8_GRAIN_CALORIES;
		double expectedFruitsVeggiesCalories = ADULTMALE_VEGGIE_CALORIES + CHILDO8_VEGGIE_CALORIES + CHILDU8_VEGGIE_CALORIES;
		double expectedProteinCalories = ADULTMALE_PROTEIN_CALORIES + CHILDO8_PROTEIN_CALORIES + CHILDU8_PROTEIN_CALORIES;
		double expectedOtherCalories = ADULTMALE_OTHER_CALORIES + CHILDO8_OTHER_CALORIES + CHILDU8_OTHER_CALORIES;

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
