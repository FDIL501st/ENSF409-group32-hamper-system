/**
@author Saman Hosseini <a href="mailto:saman.hosseini@ucalgary.ca">saman.hosseini@ucalgary.ca</a>
@version 1.1
@since 1.0 
*/

package edu.ucalgary.ensf409;

import java.util.*;

public class HamperRequest{
	
	// Member Variables.
	
	private ArrayList<Hamper> hampers;
	private boolean quit;
	private int numHampers = 0;
	
	// Methods.
	
	public HamperRequest(Hamper[] hamper){
		hampers = new ArrayList<Hamper>();
		for(int i = 0; i < hamper.length; i++){
			hampers.add(hamper[i]);
			numHampers++;
		}
	}
	
	public void addHamper(Hamper hamper){
		hampers.add(hamper);
		numHampers++;
	}
	
	public ArrayList<Hamper> getHampers(){
		return hampers;
	}
	
}