/**
@author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a>
@version 1.1
@since 1.0 
*/

//package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class FoodCalculatorGettersTestSam{
	
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
	public void testFoodCalculatorGettersSam(){
		
		/*
		Notes to bring up:
		- I think we should take a look at the relationship between HamperRequest and Hamper, it might be aggregation.
		- Should calculateFoodCombos() return an arraylist of strings? Shouldn't it directly change the food combos member variable without
		  needing to return a value?
		- Are the calculate methods for each calorie type called during the constructor of FoodCalculator?
		  If so, then shouldn't they be helper methods? Does this mean we don't need to test them?
		  
		
		*/
		
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
	
}