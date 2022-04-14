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
	
	// Methods.
	public HamperRequest(Hamper[] hamperRequests) {
		hampers = new ArrayList<>();
		for (Hamper hamper : hamperRequests) {
			hampers.add(hamper);
		}

	
	/*
	public HamperRequest(ArrayList<int[]> hamperRequests){
	
		hampers = new ArrayList<Hamper>();

		// adding in new hamper
		for(int[] hamperData : hamperRequests){
			Hamper newHamper = new Hamper(hamperData[0], hamperData[1], hamperData[2], hamperData[3]);
			hampers.add(newHamper);
			numHampers++;
		}
	*/
		
		// for(int i = 0; i < hamper.length; i++){
		// 	hampers.add(hamper[i]);
		// 	numHampers++;
		// }
	}
	
	// I think we dont need this one(?)
	public void addHamper(Hamper hamper){
		hampers.add(hamper);
		numHampers++;
	}
	
	public ArrayList<Hamper> getHampers(){
		return hampers;
	}
	
}
