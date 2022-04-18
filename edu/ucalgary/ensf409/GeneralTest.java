/**
 * <h1>GeneralTest</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.Assert.*;
import org.junit.*;


public class GeneralTest{
	
	@BeforeClass public static void login() {
		DatabaseReader.initializeConnection();
	}
	@AfterClass public static void logout() {
		DatabaseReader.close();
	}
	// @Before
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

	ChildOverEight.setGrains(CHILDO8_GRAIN_CALORIES);
	ChildOverEight.setVeggies(CHILDO8_VEGGIE_CALORIES);
	ChildOverEight.setProteins(CHILDO8_PROTEIN_CALORIES);
	ChildOverEight.setOthers(CHILDO8_OTHER_CALORIES);
	ChildOverEight.setCalories(CHILDO8_TOTAL_CALORIES);


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
	
	FoodInventory inventory = new FoodInventory();
	FoodInventory.setInventory(sampleDatabase);
	}
	
	
	@Test
	public void oneHamperTest(){

		ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "60", "10", "30", "10"};
		String[] add2 = {"2", "Chicken", "10", "0", "50", "40", "10"};
		String[] add3 = {"3", "Pie", "30", "40", "10", "20", "10"};
		String[] add4 = {"4", "Yam", "40", "50", "10", "0", "10"};
		expectedFoodCombos.add(add1);
		expectedFoodCombos.add(add2);
		expectedFoodCombos.add(add3);
		expectedFoodCombos.add(add4);

		// Create ArrayList<int[]>
		int[] peoples = {1,1,0,0};
		ArrayList<int[]> list = new ArrayList<>(1);
		list.add(peoples);
		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReference = myRequest.getHampers().get(0).getFoodCalculator();

		// Calculate the food combos.
		foodCalcReference.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombos = foodCalcReference.getHamperFoodCombo();

		assertEquals("The hamper created with only one hamper in the request was not as expected", expectedFoodCombos, actualFoodCombos);
	}



	@Test
	public void testTwoDuplicateHampers(){

		ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "60", "10", "30", "10"};
		String[] add2 = {"2", "Chicken", "10", "0", "50", "40", "10"};
		String[] add3 = {"3", "Pie", "30", "40", "10", "20", "10"};
		String[] add4 = {"4", "Yam", "40", "50", "10", "0", "10"};
		expectedFoodCombos.add(add1);
		expectedFoodCombos.add(add2);
		expectedFoodCombos.add(add3);
		expectedFoodCombos.add(add4);
		
		// Create int[] for numer of peoples in Hamper
		int[] peoples = {1,1,0,0};
		ArrayList<int[]> list = new ArrayList<>(2);
		list.add(peoples);
		list.add(peoples);

		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
		FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

		foodCalcReferenceHamp1.calculateFoodCombos();
		foodCalcReferenceHamp2.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombo();
		ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombo();

		assertEquals("The first duplicate hamper was not as expected", expectedFoodCombos, actualFoodCombosHamp1);

		assertEquals("The second duplicate hamper was not as expected", expectedFoodCombos, actualFoodCombosHamp2);
	}

	@Test
	public void testTwoDifferentHampers(){

		ArrayList<String[]> expectedFoodCombosHamp1 = new ArrayList<String[]>();
		String[] add1 = {"1", "Apples", "0", "60", "10", "30", "10"};
		expectedFoodCombosHamp1.add(add1);
		String[] add2 = {"2", "Chicken", "10", "0", "50", "40", "10"};
		expectedFoodCombosHamp1.add(add2);
		String[] add3 = {"3", "Pie", "30", "40", "10", "20", "10"};
		expectedFoodCombosHamp1.add(add3);
		String[] add4 = {"4", "Yam", "40", "50", "10", "0", "10"};
		expectedFoodCombosHamp1.add(add4);

		ArrayList<String[]> expectedFoodCombosHamp2 = new ArrayList<String[]>();
		String[] add5 = {"5", "Apples", "0", "60", "10", "30", "10"};
		expectedFoodCombosHamp2.add(add5);
		String[] add6 = {"6", "Chicken", "10", "0", "50", "40", "10"};
		expectedFoodCombosHamp2.add(add6);
		String[] add7 = {"7", "Pie", "30", "40", "10", "20", "10"};
		expectedFoodCombosHamp2.add(add7);
		String[] add8 = {"8", "Yam", "40", "50", "10", "0", "10"};
		expectedFoodCombosHamp2.add(add8);
		String[] add9 = {"9", "Gum", "30", "30", "30", "10", "100"};
		expectedFoodCombosHamp2.add(add9);


		int[] p1 = {1,1,0,0};
		int[] p2 = {1,1,0,1};
		ArrayList<int[]> list = new ArrayList<>(2);
		list.add(p1);
		list.add(p2);
				
		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(list);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
		FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

		foodCalcReferenceHamp1.calculateFoodCombos();
		foodCalcReferenceHamp2.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombo();
		ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombo();

		assertEquals("The first hamper was not as expected", expectedFoodCombosHamp1, actualFoodCombosHamp1);

		assertEquals("The second duplicate hamper was not as expected", expectedFoodCombosHamp2, actualFoodCombosHamp2);
	}

}
