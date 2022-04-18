/**
 * <h1>Hamper</h1>
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

public class Hamper{
	
		// Member Variables.
		
		private FoodCalculator foodCalculator;
		private int numAdultMales;
		private int numAdultFemales;
		private int numChildU8;
		private int numChildO8;
		
		// Methods.

		 /**
		  * Constructor for the hamper class
		  * @param numAdultMales is the number of adult males in the hamper
		  * @param numAdultFemales is the number of adult females in the hamper
		  * @param numChildU8 is the number of children under 8 in the hamper
		  * @param numChildO8 is the number of children over 8 in the hamper
		  */
		public Hamper(int numAdultMales, int numAdultFemales, int numChildU8, int numChildO8){
			
			this.numAdultMales = numAdultMales;
			this.numAdultFemales = numAdultFemales;
			this.numChildU8 = numChildU8;
			this.numChildO8 = numChildO8;
			this.foodCalculator = new FoodCalculator(numAdultMales, numAdultFemales, numChildU8, numChildO8);
		}
		
		/**
		 * Getter for FoodCalculator
		 * @return a FoodCalulator object
		 */
		public FoodCalculator getFoodCalculator(){
			return foodCalculator;
		}
		
		/**
		 * Getter for number of adult males in the hamper
		 * @return number of adult males in the hamper
		 */
		public int getNumAdultMales(){
			return numAdultMales;
		}
		
		/**
		 * Getter for number of adult females in the hamper
		 * @return number of adult females in the hamper
		 */
		public int getNumAdultFemales(){
			return numAdultFemales;
		}
		
		/**
		 * Getter for number of children under 8 in the hamper
		 * @return number of children under 8 in the hamper
		 */
		public int getNumChildrenU8(){
			return numChildU8;
		}

		/**
		 * Getter for number of children over 8 in the hamper
		 * @return number of children over 8 in the hamper
		 */
		public int getNumChildrenO8(){
			return numChildO8;
		}
		
}