/**
@author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a>
@version 1.1
@since 1.0 
*/

public class GeneralTest{
	
	
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

	ChildO8.setGrains(CHILDO8_GRAIN_CALORIES);
	ChildO8.setVeggies(CHILDO8_VEGGIE_CALORIES);
	ChildO8.setProteins(CHILDO8_PROTEIN_CALORIES);
	ChildO8.setOthers(CHILDO8_OTHER_CALORIES);
	ChildO8.setCalories(CHILDO8_TOTAL_CALORIES);


	Arraylist<String[]> sampleDatabase = new Arraylist<String[]>();

	sampleDatabase.add({“1”, “Apples”, “0”, “60”, “10”, “30”, “10”});
	sampleDatabase.add({“2”, “Chicken”, “10”, “0”, “50”, “40”, “10”});
	sampleDatabase.add({“3”, “Pie”, “30”, “40”, “10”, “20”, “10”});
	sampleDatabase.add({“4”, “Yam”, “40”, “50”, “10”, “0”, “10”});
	sampleDatabase.add({“5”, “Apples”, “0”, “60”, “10”, “30”, “10”});
	sampleDatabase.add({“6”, “Chicken”, “10”, “0”, “50”, “40”, “10”});
	sampleDatabase.add({“7”, “Pie”, “30”, “40”, “10”, “20”, “10”});
	sampleDatabase.add({“8”, “Yam”, “40”, “50”, “10”, “0”, “10”});
	sampleDatabase.add({“9”, “Gum”, “30”, “30”, “30”, “10”, “100”});

	FoodInventory inventory = new FoodInventory();
	FoodInventory.setInventory(sampleDatabase);

	@Test
	public void oneHamperTest(){

		ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();
		expectedFoodCombos.add({“1”, “Apples”, “0”, “60”, “10”, “30”, “10”});
		expectedFoodCombos.add({“2”, “Chicken”, “10”, “0”, “50”, “40”, “10”};;
		expectedFoodCombos.add({“3”, “Pie”, “30”, “40”, “10”, “20”, “10”});
		expectedFoodCombos.add({“4”, “Yam”, “40”, “50”, “10”, “0”, “10”});

		// Create a new hamper object
		Hamper myHamper = new Hamper(1,1,0,0);
				
		// Setup an array of one hamper.
		Hamper[] hamperArr = { myHamper };
				
		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(hamperArr);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReference = myRequest.getHampers().get(0).getFoodCalculator();

		// Calculate the food combos.
		foodCalcReference.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombos = foodCalcReference.getHamperFoodCombos();

		assertEquals(“The hamper created with only one hamper in the request was not as expected”, expectedFoodCombos, actualFoodCombos);
	}



	@Test
	public void testTwoDuplicateHampers(){

	ArrayList<String[]> expectedFoodCombos = new ArrayList<String[]>();
	expectedFoodCombos.add({“1”, “Apples”, “0”, “60”, “10”, “30”, “10”});
	expectedFoodCombos.add({“2”, “Chicken”, “10”, “0”, “50”, “40”, “10”});
	expectedFoodCombos.add({“3”, “Pie”, “30”, “40”, “10”, “20”, “10”});
	expectedFoodCombos.add({“4”, “Yam”, “40”, “50”, “10”, “0”, “10”});


	// Create a new hamper object
	Hamper myHamper = new Hamper(1,1,0,0);

	Hamper myHamper2 = new Hamper(1,1,0,0);
			
	// Setup an array of two hampers.
	Hamper[] hamperArr = { myHamper, myHamper2 };
			
	// Create HamperRequest object for testing. 
	HamperRequest myRequest = new HamperRequest(hamperArr);

	// Grab the FoodCalculator reference for testing.		
	FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
	FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

	foodCalcReferenceHamp1.calculateFoodCombos();
	foodCalcReferenceHamp2.calculateFoodCombos();

	ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombos();
	ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombos();

	assertEquals(“The first duplicate hamper was not as expected”, expectedFoodCombos, actualFoodCombosHamp1);

	assertEquals(“The second duplicate hamper was not as expected”, expectedFoodCombos, actualFoodCombosHamp2);


	@Test
	public void testTwoDifferentHampers(){

		ArrayList<String[]> expectedFoodCombosHamp1 = new ArrayList<String[]>();
		expectedFoodCombosHamp1.add({“1”, “Apples”, “0”, “60”, “10”, “30”, “10”});
		expectedFoodCombosHamp1.add({“2”, “Chicken”, “10”, “0”, “50”, “40”, “10”});
		expectedFoodCombosHamp1.add({“3”, “Pie”, “30”, “40”, “10”, “20”, “10”});
		expectedFoodCombosHamp1.add({“4”, “Yam”, “40”, “50”, “10”, “0”, “10”});

		ArrayList<String[]> expectedFoodCombosHamp2 = new ArrayList<String[]>();
		expectedFoodCombosHamp2.add({“5”, “Apples”, “0”, “60”, “10”, “30”, “10”});
		expectedFoodCombosHamp2.add({“6”, “Chicken”, “10”, “0”, “50”, “40”, “10”});
		expectedFoodCombosHamp2.add({“7”, “Pie”, “30”, “40”, “10”, “20”, “10”});
		expectedFoodCombosHamp2.add({“8”, “Yam”, “40”, “50”, “10”, “0”, “10”});
		expectedFoodCombosHamp2.add({“9”, “Gum”, “30”, “30”, “30”, “10”, “100”});


		// Create a new hamper object
		Hamper myHamper = new Hamper(1, 1, 0, 0);

		Hamper myHamper2 = new Hamper(1,1,0,1);
				
		// Setup an array of two hampers.
		Hamper[] hamperArr = { myHamper, myHamper2 };
				
		// Create HamperRequest object for testing. 
		HamperRequest myRequest = new HamperRequest(hamperArr);

		// Grab the FoodCalculator reference for testing.		
		FoodCalculator foodCalcReferenceHamp1 = myRequest.getHampers().get(0).getFoodCalculator();
		FoodCalculator foodCalcReferenceHamp2 = myRequest.getHampers().get(1).getFoodCalculator();

		foodCalcReferenceHamp1.calculateFoodCombos();
		foodCalcReferenceHamp2.calculateFoodCombos();

		ArrayList<String[]> actualFoodCombosHamp1 = foodCalcReferenceHamp1.getHamperFoodCombos();
		ArrayList<String[]> actualFoodCombosHamp2 = foodCalcReferenceHamp2.getHamperFoodCombos();

		assertEquals(“The first hamper was not as expected”, expectedFoodCombosHamp1, actualFoodCombosHamp1);

		assertEquals(“The second duplicate hamper was not as expected”, expectedFoodCombosHamp2, actualFoodCombosHamp2);
	}

		
}