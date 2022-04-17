/**
 * <h1>HamperRequestTest</h1>
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

public class HamperRequestTest{
	
	final int ADULTMALES = 1;
	final int ADULTFEMALES = 1;
	final int CHILDU8 = 1;
	final int CHILDO8 = 1;
	
	/**
     	* Testing that the getHampers method properly returns the hampers data structure in the HamperRequest object after using the addHamper method. 
     	*/
	
	public void testGetAddHampers(){
		
		//// Setting up variables for testing.
		
		// Create a new hamper object
		Hamper myHamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
		
		// Create a new hamper arraylist with two hamper objects.
		ArrayList<Hamper> expectedHamperList = new ArrayList<Hamper>();
		expectedHamperList.add(myHamper);
		expectedHamperList.add(myHamper);
		
		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData = {ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8};
		
		hamperRequests.add(hamperData);
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests);
		
		// Add a new Hamper object with addHamper.
		myRequest.addHamper(myHamper);
		
		//// Testing.
		
		// Use the getHampers() method to retrieve the actual hamper arraylist from the HamperRequest object.
		ArrayList<Hamper> actualHamperList = myRequest.getHampers();
		
		assertEquals("Value of getHampers() did not match what was expected", expectedHamperList, actualHamperList);
		
	}
	
	/**
     	* Testing that the getHampers method properly returns the hampers data structure in the HamperRequest object.
     	*/
	
	public void testGetHampers(){
		
		//// Setting up variables for testing.
		
		// Create a new hamper object
		Hamper myHamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
		
		// Create a new hamper arraylist with one hamper object.
		ArrayList<Hamper> expectedHamperList = new ArrayList<Hamper>();
		expectedHamperList.add(myHamper);
		
		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData = {ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8};
		
		hamperRequests.add(hamperData);
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests);
		
		//// Testing.
		
		// Use the getHampers() method to retrieve the actual hamper arraylist from the HamperRequest object.
		ArrayList<Hamper> actualHamperList = myRequest.getHampers();
		
		assertEquals("Value of getHampers() did not match what was expected", expectedHamperList, actualHamperList);
		
	}
	
	/**
     	* Testing that the constructor of the HamperRequest class properly creates a non null instance of the object.
     	*/
	
	public void testHamperRequestConstructor(){
		
		//// Setting up variables for testing.
		
		// Create a new ArrayList of integer arrays and populate it.
		ArrayList<int[]> hamperRequests = new ArrayList<int[]>();
		
		int[] hamperData = {ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8};
		
		hamperRequests.add(hamperData);
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperRequests);
		
		// Variables for status
        	boolean isNull = false;
		
		if(myRequest == null){
			isNull = true;
		}
		
		//// Testing.
		
		assertFalse("The HamperRequest object initialized to null.", isNull);
		
	}
	
}
