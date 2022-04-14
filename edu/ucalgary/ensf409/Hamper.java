/**
 * <h1>Hamper</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.1
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import java.util.*;

public class Hamper{
	
		// Member Variables.
		
		private FoodCalculator foodCalculator;
		private int numAdultMales;
		private int numAdultFemales;
		private int numChildU8;
		private int numChildO8;
		
		// Methods.
		
		/**
     		* Constructor. 
     		*/
		public Hamper(int numAdultMales, int numAdultFemales, int numChildU8, int numChildO8){
			
			this.numAdultMales = numAdultMales;
			this.numAdultFemales = numAdultFemales;
			this.numChildU8 = numChildU8;
			this.numChildO8 = numChildO8;
			this.foodCalculator = new FoodCalculator(numAdultMales, numAdultFemales, numChildU8, numChildO8);
			
		}
		
		/**
     		* Getters. 
     		*/
		public FoodCalculator getFoodCalculator(){
			return foodCalculator;
		}
		
		public int getNumAdultMales(){
			return numAdultMales;
		}
		
		public int getNumAdultFemales(){
			return numAdultFemales;
		}
		
		public int getNumChildrenU8(){
			return numChildU8;
		}
		
		public int getNumChildrenO8(){
			return numChildO8;
		}
		
}
