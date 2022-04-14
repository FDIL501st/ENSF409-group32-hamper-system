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
	
	public void testGetAddHampers(){
		
		//// Setting up variables for testing.
		
		// Create a new hamper object
		Hamper myHamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
		
		// Create a new hamper arraylist with two hamper objects.
		ArrayList<Hamper> myHamperList = new ArrayList<Hamper>();
		myHamperList.add(myHamper);
		myHamperList.add(myHamper);
		
		// Setup an array of one hamper.
		Hamper[] hamperArr = { myHamper };
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperArr);
		
		// Add a new Hamper object with addHamper.
		myRequest.addHamper(myHamper);
		
		//// Testing.
		
		// Use the getHampers() method to retrieve the actual hamper arraylist from the HamperRequest object.
		ArrayList<Hamper> actualHamperList = myRequest.getHampers();
		
		assertEquals("Value of getHampers() did not match what was expected", myHamperList, actualHamperList);
		
	}
	
	public void testGetHampers(){
		
		//// Setting up variables for testing.
		
		// Create a new hamper object
		Hamper myHamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
		
		// Create a new hamper arraylist with one hamper object.
		ArrayList<Hamper> myHamperList = new ArrayList<Hamper>();
		myHamperList.add(myHamper);
		
		// Setup an array of one hamper.
		Hamper[] hamperArr = { myHamper };
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperArr);
		
		//// Testing.
		
		// Use the getHampers() method to retrieve the actual hamper arraylist from the HamperRequest object.
		ArrayList<Hamper> actualHamperList = myRequest.getHampers();
		
		assertEquals("Value of getHampers() did not match what was expected", myHamperList, actualHamperList);
		
	}
	
	public void testHamperRequestConstructor(){
		
		//// Setting up variables for testing.
		
		// Create a new hamper object
		Hamper myHamper = new Hamper(ADULTMALES, ADULTFEMALES, CHILDU8, CHILDO8);
		
		// Setup an array of one hamper.
		Hamper[] hamperArr = { myHamper };
		
		// Create HamperRequest object for testing.
		HamperRequest myRequest = new HamperRequest(hamperArr);
		
		// Variables for status
        boolean isNull = false;
		
		if(myRequest == null){
			isNull = true;
		}
		
		//// Testing.
		
		assertFalse("The HamperRequest object initialized to null.", isNull);
		
	}
	
}
