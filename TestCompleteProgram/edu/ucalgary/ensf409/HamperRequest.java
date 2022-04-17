/**
 * <h1>HamperRequest</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;

public class HamperRequest{
	
	// Member Variables.
	
	private ArrayList<Hamper> hampers;
	private boolean quit;
	private int numHampers = 0;

	OrderForm orderForm;
	FoodInventory foodInventory;
	
	
	/**
     	* The Constructor takes in an ArrayList of integer arrays.
	* Each integer array contains the hamper data for the number of people requested.
	* The loop uses the hamper constructor with the information in each array to construct and add a new hamper to the data structure.
     	*/
	public HamperRequest(ArrayList<int[]> hamperRequests){
	
		hampers = new ArrayList<Hamper>();
				
		// adding in new hamper
		for(int[] hamperData : hamperRequests){
			Hamper newHamper = new Hamper(hamperData[0], hamperData[1], hamperData[2], hamperData[3]);
			hampers.add(newHamper);
			numHampers++;
		}

		DatabaseReader.initializeConnection();
		foodInventory = new FoodInventory();
		orderForm = new OrderForm();
		DatabaseReader.close();

		
		// for(int i = 0; i < hamper.length; i++){
		// 	hampers.add(hamper[i]);
		// 	numHampers++;
		// }
	}

	/**
    * The addHampers method adds a new Hamper object to the hampers member.
    */
	public void addHampers(ArrayList<int[]> hamperRequests){

		for(int[] hamperData : hamperRequests){
			Hamper newHamper = new Hamper(hamperData[0], hamperData[1], hamperData[2], hamperData[3]);
			hampers.add(newHamper);
			numHampers++;
		}
	}
	
	/**
     	* Getter method for hampers member. 
     	*/
	public ArrayList<Hamper> getHampers(){
		return hampers;
	}
	
	public void createHampers(){

		DatabaseReader.initializeConnection();

		double wholeGrainCalories;
		double fruitsVeggiesCalories;
		double proteinCalories;
		double otherCalories;

		for(Hamper hamper : hampers){

			wholeGrainCalories = hamper.getFoodCalculator().getWholeGrainCalories();
			fruitsVeggiesCalories = hamper.getFoodCalculator().getFruitsVeggiesCalories();
			proteinCalories = hamper.getFoodCalculator().getProteinCalories();
			otherCalories = hamper.getFoodCalculator().getOtherCalories();


			double[] neededCalories = {wholeGrainCalories, fruitsVeggiesCalories, proteinCalories, otherCalories};

			hamper.getFoodCalculator().calculateFoodCombos();

			boolean shortage = FoodInventory.checkShortage(neededCalories);
	
			if(shortage == true){
				orderForm.reportShortage(hampers);
			} else{
				orderForm.createForm(hampers);
			}
		}

        DatabaseReader.close();
	}

}
