/**
 * <h1>HamperRequest</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem Soufi <a href="mailto:adem.soufi@ucalgary.ca">adem.soufi@ucalgary.ca</a> | UCID: 30101252
 * @author Fadil Husain <a href="mailto:fadil.husain@ucalgary.ca">fadil.husain@ucalgary.ca</a> | UCID: 30113409
 * @author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a> | UCID: 30092208
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;

public class HamperRequest{
	
	// Member Variables.
	private ArrayList<Hamper> hampers;

	private OrderForm orderForm;
	private FoodInventory foodInventory;
	
	/**
	 * This constructor for HamperRequest was created explicitly for the purpose of testing to
	 * get around the database access required for the primary constructor
	 * @param hamperRequests an ArrayList of int arrays containing data regarding each hamper. 
	 * The data in each array for each hamper is formatted as: adultMales, adultFemales, childO8, childU8
	 */
	public HamperRequest(ArrayList<int[]> hamperRequests){

		//DatabaseReader.initializeConnection();

		foodInventory = new FoodInventory();
		orderForm = new OrderForm();
	
		hampers = new ArrayList<Hamper>();
				
		// adding in new hamper
		for(int[] hamperData : hamperRequests){
			Hamper newHamper = new Hamper(hamperData[0], hamperData[1], hamperData[2], hamperData[3]);
			hampers.add(newHamper);
		}

		//DatabaseReader.close();

	}

	/**
	 * This constructor for HamperRequest was created explicitly for the purpose of testing to
	 * get around the database access required for the primary constructor
	 * @param hamperRequests an ArrayList of int arrays containing data regarding each hamper. 
	 * The data in each array for each hamper is formatted as: adultMales, adultFemales, childO8, childU8
	 * @param i is an integer passed in from the tests to indicate that the 'testing' constructor should be used
	 */

	public HamperRequest(ArrayList<int[]> hamperRequests, int i){
	
		hampers = new ArrayList<Hamper>();
				
		// adding in new hamper
		for(int[] hamperData : hamperRequests){
			Hamper newHamper = new Hamper(hamperData[0], hamperData[1], hamperData[2], hamperData[3]);
			hampers.add(newHamper);
		}
	}

	/**
	 * overwriteHampers is utilized for overwriting the hamperRequests ArrayList. It is utilized when the 
	 * program has already created a hamper request and the user is requesting another set of hampers.
	 * @param hamperRequests an ArrayList of int arrays containing data regarding each hamper. 
	 * The data in each array for each hamper is formatted as: adultMales, adultFemales, childO8, childU8
	 */
	public void overwriteHampers(ArrayList<int[]> hamperRequests){

		hampers.clear();

		for(int[] hamperData : hamperRequests){
			Hamper newHamper = new Hamper(hamperData[0], hamperData[1], hamperData[2], hamperData[3]);
			hampers.add(newHamper);
		}
	}
	
	/**
    	* Getter method for hampers member. 
	* @return an ArrayList of hampers
    	*/
	public ArrayList<Hamper> getHampers(){
		return hampers;
	}
	
	/**
	 * createHampers is the function called to perform the calculation of the best food combos 
	 * for each hamper in turn. It checks for any shortages and either creates the order form and 
	 * updates the inventory, or reports a shortage.
	 */
	public void createHampers(){

		//DatabaseReader.initializeConnection();

		double wholeGrainCalories;
		double fruitsVeggiesCalories;
		double proteinCalories;
		double otherCalories;

		boolean shortage = false;

		for(Hamper hamper : hampers){

			// Get the different types of calories needed for the hamper
			wholeGrainCalories = hamper.getFoodCalculator().getWholeGrainCalories();
			fruitsVeggiesCalories = hamper.getFoodCalculator().getFruitsVeggiesCalories();
			proteinCalories = hamper.getFoodCalculator().getProteinCalories();
			otherCalories = hamper.getFoodCalculator().getOtherCalories();

			// Check for any shortages
			double[] neededCalories = {wholeGrainCalories, fruitsVeggiesCalories, proteinCalories, otherCalories};
			shortage = FoodInventory.checkShortage(neededCalories);
	
			if (shortage == true){
				break;
			}

			// Calculate food combos
			hamper.getFoodCalculator().calculateFoodCombos();

			// Remove from the program's inventory
			FoodInventory.removeHamper(hamper.getFoodCalculator().getHamperFoodCombo());
		}

		// check if there was a shortage and print the appropriate form, and update the inventory/database
		if (shortage == true){
			orderForm.reportShortage(hampers);
			FoodInventory.restoreInventory();
		} else{
			orderForm.createForm(hampers);
			FoodInventory.updateDatabase();
		}

		//DatabaseReader.close();

	
	}
}
