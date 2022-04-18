/**
 * <h1>GeneralTest</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem Soufi <a href="mailto:adem.soufi@ucalgary.ca">adem.soufi@ucalgary.ca</a> | UCID: 30101252
 * @author Fadil Husain <a href="mailto:fadil.husain@ucalgary.ca">fadil.husain@ucalgary.ca</a> | UCID: 30113409
 * @author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a> | UCID: 30092208
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 2.3
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;

public class GeneralTest{

	// Expected calorie values for each type of person.
	final double ADULTMALE_GRAIN_CALORIES = 4;
	final double ADULTMALE_VEGGIE_CALORIES = 8;
	final double ADULTMALE_PROTEIN_CALORIES = 5;
	final double ADULTMALE_OTHER_CALORIES = 5;
	final double ADULTMALE_TOTAL_CALORIES = 22;

	final double ADULTFEMALE_GRAIN_CALORIES = 4;
	final double ADULTFEMALE_VEGGIE_CALORIES = 7;
	final double ADULTFEMALE_PROTEIN_CALORIES = 3;
	final double ADULTFEMALE_OTHER_CALORIES = 4;
	final double ADULTFEMALE_TOTAL_CALORIES = 18;

	final double CHILDU8_GRAIN_CALORIES = 20;
	final double CHILDU8_VEGGIE_CALORIES = 20;
	final double CHILDU8_PROTEIN_CALORIES = 20;
	final double CHILDU8_OTHER_CALORIES = 20;
	final double CHILDU8_TOTAL_CALORIES = 80;

	final double CHILDO8_GRAIN_CALORIES = 30;
	final double CHILDO8_VEGGIE_CALORIES = 30;
	final double CHILDO8_PROTEIN_CALORIES = 30;
	final double CHILDO8_OTHER_CALORIES = 10;
	final double CHILDO8_TOTAL_CALORIES = 100;

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

		ArrayList<String[]> sampleDatabase = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "6", "1", "3", "10"};
		sampleDatabase.add(add1);
		String[] add2 = {"2", "Chicken", "1", "0", "5", "4", "10"};
		sampleDatabase.add(add2);
		String[] add3 = {"3", "Pie", "3", "4", "1", "2", "10"};
		sampleDatabase.add(add3);
		String[] add4 = {"4", "Yam", "4", "5", "1", "0", "10"};
		sampleDatabase.add(add4);
		String[] add5 = {"5", "Milk", "0", "6", "1", "3", "10"};
		sampleDatabase.add(add5);
		String[] add6 = {"6", "Beef", "1", "0", "5", "4", "10"};
		sampleDatabase.add(add6);
		String[] add7 = {"7", "Pasta", "3", "4", "1", "2", "10"}; 
		sampleDatabase.add(add7);
		String[] add8 = {"8", "Orange", "4", "5", "1", "0", "10"};
		sampleDatabase.add(add8);
		String[] add9 = {"9", "Gum", "3", "3", "3", "1", "100"};
		sampleDatabase.add(add9);
		
		FoodInventory.setInventory(sampleDatabase);
	}
	
	
	/**
	 * Test calculateFoodCombos with one hamper in the request.
	 */
	@Test
	public void oneHamperTest(){

		// Expected Values
		ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "6", "1", "3", "10"};
		String[] add2 = {"2", "Chicken", "1", "0", "5", "4", "10"};
		String[] add3 = {"3", "Pie", "3", "4", "1", "2", "10"};
		String[] add4 = {"4", "Yam", "4", "5", "1", "0", "10"};
		expectedFoodCombos.add(add4);
		expectedFoodCombos.add(add3);
		expectedFoodCombos.add(add2);
		expectedFoodCombos.add(add1);

		// Create ArrayList<int[]>
		int[] peoples = {1,1,0,0};
		ArrayList<int[]> list = new ArrayList<>(1);
		list.add(peoples);
		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list, 0);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReference = myRequest.getHampers().get(0).getFoodCalculator();

		// Calculate the food combos.
		foodCalcReference.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombos = foodCalcReference.getHamperFoodCombo();

		// Test if the expected and actual combos are equal
		boolean isEqual = true;

		for(int i = 0; i < actualFoodCombos.size(); i++){
			if(!actualFoodCombos.get(i)[1].equals(expectedFoodCombos.get(i)[1])){
				isEqual = false;
			}
		}

		assertTrue("Actual food expected do not match the expected food combos.", isEqual);
		//assertEquals("The hamper created with only one hamper in the request was not as expected", expectedFoodCombos, actualFoodCombos);
	}

	/**
	 * Test calculateFoodCombos with 2 identical hampers in the request.
	 */
	@Test
	public void twoDuplicateHampersTest(){

		// Expected values - they will be the same items for each hamper as nothing is removed from the inventory
		ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "6", "1", "3", "10"};
		String[] add2 = {"2", "Chicken", "1", "0", "5", "4", "10"};
		String[] add3 = {"3", "Pie", "3", "4", "1", "2", "10"};
		String[] add4 = {"4", "Yam", "4", "5", "1", "0", "10"};
		expectedFoodCombos.add(add4);
		expectedFoodCombos.add(add3);
		expectedFoodCombos.add(add2);
		expectedFoodCombos.add(add1);

		// Create int[] for number of peoples in Hamper
		int[] peoples = {1,1,0,0};
		ArrayList<int[]> list = new ArrayList<>(2);
		list.add(peoples);
		list.add(peoples);

		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list, 0);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
		FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

		// Calculate the food combos.
		foodCalcReferenceHamp1.calculateFoodCombos();
		foodCalcReferenceHamp2.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombo();
		ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombo();

		// Test if the expected and actual combos are equal
		boolean isEqualHamp1 = true;

		for(int i = 0; i < actualFoodCombosHamp1.size(); i++){
			if(!actualFoodCombosHamp1.get(i)[1].equals(expectedFoodCombos.get(i)[1])){
				isEqualHamp1 = false;
			}
		}

		boolean isEqualHamp2 = true;

		for(int i = 0; i < actualFoodCombosHamp2.size(); i++){
			if(!actualFoodCombosHamp2.get(i)[1].equals(expectedFoodCombos.get(i)[1])){
				isEqualHamp2 = false;
			}
		}

		assertTrue("Actual food combos do not match the expected food combos for the first duplicate hamper", isEqualHamp1);
		assertTrue("Actual food combos do not match the expected food combos for the second duplicate hamper.", isEqualHamp2);
	}

	/**
	 * Test calculateFoodCombos with 2 different hampers in the request.
	 */
	@Test
	public void twoDifferentHampersTest(){

		// Expected values.
		ArrayList<String[]> expectedFoodCombosHamp1 = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "6", "1", "3", "10"};
		String[] add2 = {"2", "Chicken", "1", "0", "5", "4", "10"};
		String[] add3 = {"3", "Pie", "3", "4", "1", "2", "10"};
		String[] add4 = {"4", "Yam", "4", "5", "1", "0", "10"};

		expectedFoodCombosHamp1.add(add4);
		expectedFoodCombosHamp1.add(add3);
		expectedFoodCombosHamp1.add(add2);
		expectedFoodCombosHamp1.add(add1);

		ArrayList<String[]> expectedFoodCombosHamp2 = new ArrayList<String[]>();
		String[] add5 = {"5", "Milk", "0", "6", "1", "3", "10"};
		String[] add6 = {"6", "Beef", "1", "0", "5", "4", "10"};
		String[] add7 = {"7", "Pasta", "3", "4", "1", "2", "10"};
		String[] add8 = {"8", "Orange", "4", "5", "1", "0", "10"};
		String[] add9 = {"9", "Gum", "3", "3", "3", "1", "100"};

		expectedFoodCombosHamp2.add(add9);
		expectedFoodCombosHamp2.add(add8);
		expectedFoodCombosHamp2.add(add7);
		expectedFoodCombosHamp2.add(add6);
		expectedFoodCombosHamp2.add(add5);

		// Create int[] for number of peoples in Hamper
		int[] p1 = {1,1,0,0};
		int[] p2 = {1,1,0,1};
		ArrayList<int[]> list = new ArrayList<>(2);
		list.add(p1);
		list.add(p2);
				
		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list, 0);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
		FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

		// Calculate the food combos.
		foodCalcReferenceHamp1.calculateFoodCombos();
		foodCalcReferenceHamp2.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombo();
		ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombo();
		
		// Test if the expected and actual combos are equal
		boolean isEqualHamp1 = true;

		for(int i = 0; i < actualFoodCombosHamp1.size(); i++){
			if(!actualFoodCombosHamp1.get(i)[1].equals(expectedFoodCombosHamp1.get(i)[1])){
				isEqualHamp1 = false;
			}
		}

		boolean isEqualHamp2 = true;

		for(int i = 0; i < actualFoodCombosHamp2.size(); i++){
			if(!actualFoodCombosHamp2.get(i)[1].equals(expectedFoodCombosHamp2.get(i)[1])){
				isEqualHamp2 = false;
			}
		}

		assertTrue("Actual food combos do not match the expected food combos for the first hamper.", isEqualHamp1);
		assertTrue("Actual food combos do not match the expected food combos for the second hamper.", isEqualHamp2);
	}

	/**
	 * Test to ensure that a shortage is detected with one hamper.
	 */
	@Test
	public void hamperShortageTest(){

		// Expected Values
		ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();

		// Create int[] for number of peoples in Hamper
		ArrayList<int[]> list = new ArrayList<>(2);

		int[] p1 = {1,1,0,8};
		list.add(p1);

		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list, 0);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReference = myRequest.getHampers().get(0).getFoodCalculator();
		
		// Calculate the food combos.
		foodCalcReference.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombos = foodCalcReference.getHamperFoodCombo();

		assertEquals("The hamper did not have a shortage when it should.", expectedFoodCombos, actualFoodCombos);
	}

	/**
	 * Test to ensure that a shortage is detected with 2 hampers in the request,
	 * the first one can be fulfilled while the second one will have a shortage.
	 */
	@Test
	public void twoHampersSecondWithShortageTest(){

		// Expected Values
		ArrayList<String[]> expectedFoodCombosHamp1 = new ArrayList<String[]>();
		ArrayList<String[]> expectedFoodCombosHamp2 = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "6", "1", "3", "10"};
		String[] add2 = {"2", "Chicken", "1", "0", "5", "4", "10"};
		String[] add3 = {"3", "Pie", "3", "4", "1", "2", "10"};
		String[] add4 = {"4", "Yam", "4", "5", "1", "0", "10"};
		expectedFoodCombosHamp1.add(add4);
		expectedFoodCombosHamp1.add(add3);
		expectedFoodCombosHamp1.add(add2);
		expectedFoodCombosHamp1.add(add1);

		// Create int[] for number of peoples in Hamper
		ArrayList<int[]> list = new ArrayList<>(2);

		int[] p1 = {1,1,0,0};
		int[] p2 = {2,2,0,6};

		list.add(p1);
		list.add(p2);

		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list, 0);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
		FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

		// Calculate the food combos.
		foodCalcReferenceHamp1.calculateFoodCombos();
		foodCalcReferenceHamp2.calculateFoodCombos();

		// Test if the expected and actual combos are equal
		ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombo();
		ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombo();

		boolean isEqual = true;

		for(int i = 0; i < actualFoodCombosHamp1.size(); i++){
			if(!actualFoodCombosHamp1.get(i)[1].equals(expectedFoodCombosHamp1.get(i)[1])){
				isEqual = false;
			}
		}

		assertTrue("Actual food combo does not match the expected food combo for the first hamper.", isEqual);
		assertEquals("The second hamper did not have a shortage as it should.", expectedFoodCombosHamp2, actualFoodCombosHamp2);
	}
}
