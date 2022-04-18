/**
 * <h1>HamperRequestTest</h1>
 * Project for ENSF 409
 * <p>
 * @author Adem Soufi <a href="mailto:adem.soufi@ucalgary.ca">adem.soufi@ucalgary.ca</a> | UCID: 30101252
 * @author Fadil Husain <a href="mailto:fadil.husain@ucalgary.ca">fadil.husain@ucalgary.ca</a> | UCID: 30113409
 * @author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a> | UCID: 30092208
 * @author Tanvir Haer <a href="mailto:tanvir.haer@ucalgary.ca">tanvir.haer@ucalgary.ca</a> | UCID: 30039188
 * @version 2.1
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;

import java.beans.Transient;
import java.util.*;

public class HamperRequestTest{

    /**
     * Testing HamperRequest constructor to ensure it creates a non null instance of the hamper ArrayList object.
     */
	@Test
	public void testHamperRequestConstructor(){
		
		//// Setting up variables for testing.
		
		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData = {1, 0, 3, 2};
		
		hamperRequests.add(hamperData);
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests, 1);
		
		// Variables for status
        boolean isNull = false;
		
		if(myRequest == null){
			isNull = true;
		}
		
		//// Testing.
		
		assertFalse("The constructor of HamperRequest initialized the hampers to null.", isNull);
	}
	
	/**
     * Test the HamperRequest constructor and the getHampers() method
     */
	@Test
	public void getHamperTest(){
		
		// Setting up variables for testing.
		
		// Create a new hamper objects
		Hamper myHamper1 = new Hamper(1, 0, 3, 2);

		// Expected values
		int expectedNumAdultMales = 1;
		int expectedNumAdultFemales = 0;
		int expectedNumChildU8 = 3;
		int expectedNumChildO8 = 2;
		
		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData1 = {1, 0, 3, 2};
		hamperRequests.add(hamperData1);
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests, 1);
		
		//// Testing.
		
		// Use the getHampers() method to retrieve the actual hamper arraylist from the HamperRequest object.
		ArrayList<Hamper> actualHamperList = myRequest.getHampers();

		int actualNumAdultMales = actualHamperList.get(0).getNumAdultMales();
		int actualNumAdultFemales = actualHamperList.get(0).getNumAdultFemales();
		int actualNumChildU8 = actualHamperList.get(0).getNumChildrenU8();
		int actualNumChildO8 = actualHamperList.get(0).getNumChildrenO8();
		
		assertEquals("Values set for the number of adult males in the hamperRequest constructor for the first hamper did not match what was expected", expectedNumAdultMales, actualNumAdultMales);
		assertEquals("Values set for the number of adult females in the hamperRequest constructor for the first hamper did not match what was expected", expectedNumAdultFemales, actualNumAdultFemales);
		assertEquals("Values set for the number of children under 8 in the hamperRequest constructor for the first hamper did not match what was expected", expectedNumChildU8, actualNumChildU8);
		assertEquals("Values set for the number of children over 8 in the hamperRequest constructor for the first hamper did not match what was expected", expectedNumChildO8, actualNumChildO8);

	}
	
	/**
     * Test the overwriteHampers() function in HamperRequest
     */
	@Test
	public void overwriteHampersTest(){
		
		//// Setting up variables for testing.

		// Create new hamper objects to test the overwrite function
		Hamper myHamper = new Hamper(3, 1, 2, 1);

		// Expected values
		int expectedNumAdultMales = 3;
		int expectedNumAdultFemales = 1;
		int expectedNumChildU8 = 2;
		int expectedNumChildO8 = 1;
		
		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData1 = {1, 0, 3, 2};
		hamperRequests.add(hamperData1);

		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests, 1);

		// Clear the initial request ArrayList
		hamperRequests.clear();

		// Add new hampers to the request
        int[] hamperData2 = {3, 1, 2, 1};

		hamperRequests.add(hamperData2);
		
		//// Testing.
		
		// Test the overwrite function
		myRequest.overwriteHampers(hamperRequests);

		// Use the getHampers() method to retrieve the actual hamper arraylist from the HamperRequest object.
		ArrayList<Hamper> actualHamperList = myRequest.getHampers();

		int actualNumAdultMales = actualHamperList.get(0).getNumAdultMales();
		int actualNumAdultFemales = actualHamperList.get(0).getNumAdultFemales();
		int actualNumChildU8 = actualHamperList.get(0).getNumChildrenU8();
		int actualNumChildO8 = actualHamperList.get(0).getNumChildrenO8();
		
		assertEquals("Values set for the number of adult males in overwriteHampers for the hamper did not match what was expected", expectedNumAdultMales, actualNumAdultMales);
		assertEquals("Values set for the number of adult females in overwriteHampers for the hamper for the first hamper did not match what was expected", expectedNumAdultFemales, actualNumAdultFemales);
		assertEquals("Values set for the number of children under 8 in overwriteHampers for the hamper for the first hamper did not match what was expected", expectedNumChildU8, actualNumChildU8);
		assertEquals("Values set for the number of children over 8 in overwriteHampers for the hamper for the first hamper did not match what was expected", expectedNumChildO8, actualNumChildO8);
	}

	/**
	 * Test for getOrderForm
	 */
	@Test
	public void getOrderFormTest(){

		//// Setting up variables for testing.

		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData1 = {1, 0, 3, 2};
		hamperRequests.add(hamperData1);

		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests, 1);

		//// Testing.

		// Use getOrderForm() to get the form object
		OrderForm actualOrderForm = myRequest.getOrderForm();

		assertNotNull("HamperRequest constructor did not create an OrderForm object.", actualOrderForm);
	}
}