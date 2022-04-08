package edu.ucalgary.ensf409;

import java.util.*;

public class FoodCalculator{
    private double wholeGrainCalories;
    private double fruitsVeggiesCalories;
    private double proteinCalories;
    private double otherCalories;
    private double totalCalories;

    private int numAdultMales;
    private int numAdultFemales;
    private int numChildrenU8;
    private int numChildrenO8;

    ArrayList<String[]> hamperFoodCombo = new ArrayList<String[]>();

    // Constructor
    public FoodCalculator(int numAdultMales, int numAdultFemales, int numChildrenU8, int numChildrenO8){
        this.numAdultMales = numAdultMales;
        this.numAdultFemales = numAdultFemales;
        this.numChildrenU8 = numChildrenU8;
        this.numChildrenO8 = numChildrenO8;
    }

    //Getters for numbers of people
    public int getNumAdultMales() { return this.numAdultMales; }
    public int getNumAdultFemales() { return this.numAdultFemales; }
    public int getNumChildrenU8() { return this.numChildrenU8; }
    public int getNumChildrenO8() { return this.numChildrenO8; }

    //Getters for different types of calories
    public double getWholeGrainCalories() { return this.wholeGrainCalories; }
    public double getFruitsVeggiesCalories() { return this.fruitsVeggiesCalories; }
    public double getProteinCalories() { return this.proteinCalories; }
    public double getOtherCalories() { return this.otherCalories; }
    public double getTotalCalories() { return this.totalCalories; }

    //Getter for Hamper Food Combo
    public ArrayList<String[]> getHamperFoodCombo() { return this.hamperFoodCombo; }


    //Calculate the total number of whole grain calories needed
    public void calculateWholeGrainCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getGrains();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getGrains();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getGrains();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getGrains();
        }

        this.wholeGrainCalories = cals;

        //Calculations can be written as such
        // this.wholeGrainCalories = numAdultMales*AdultMale.getGrains
        // + numAdultFemales*AdultFemale.getGrains()
        // + numChildrenU8*ChildUnderEight.getGrains()
        // + numChildrenO8*ChildOverEight.getGrains();
    }

    //Calculate the total number of fruits/veggies calories needed
    public void calculateFruitsVeggiesCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getVeggies();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getVeggies();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getVeggies();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getVeggies();
        }

        this.fruitsVeggiesCalories = cals;
    }

    //Calculate the total number of protein calories needed
    public void calculateProteinCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getProteins();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getProteins();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getProteins();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getProteins();
        }

        this.proteinCalories = cals;
    }

    //Calculate the total number of other calories needed
    public void calculateOtherCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getOthers();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getOthers();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getOthers();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getOthers();
        }

        this.otherCalories = cals;
    }

    //Calculate the total number of calories needed
    public void calculateTotalCalories(){
        double cals = 0;

        for(int i = 0; i < numAdultMales; i++){
            cals += AdultMale.getCalories();
        }

        for(int i = 0; i < numAdultFemales; i++){
            cals += AdultFemale.getCalories();
        }

        for(int i = 0; i < numChildrenU8; i++){
            cals += ChildUnderEight.getCalories();
        }

        for(int i = 0; i < numChildrenO8; i++){
            cals += ChildOverEight.getCalories();
        }

        this.totalCalories = cals;
    }

        // MISSING METHOD

    public void calculateFoodCombos() {}

}