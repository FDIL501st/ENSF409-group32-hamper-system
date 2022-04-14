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

    private ArrayList<String[]> hamperFoodCombo = new ArrayList<String[]>();

    private Comparator<ArrayList<String[]>> ascendingHamperCalories = new Comparator<ArrayList<String[]>>() {
        @Override
        public int compare(ArrayList<String[]> o1, ArrayList<String[]> o2) {
            Iterator<String[]> arrayListIterator = o1.iterator();
            double o1Calories = 0;
            while (arrayListIterator.hasNext()) {
                o1Calories += totalFoodItemCalories(arrayListIterator.next());
            }
            arrayListIterator = o2.iterator();
            double o2Calories = 0;
            while (arrayListIterator.hasNext()) {
                o2Calories += totalFoodItemCalories(arrayListIterator.next());
            }
            return Double.compare(o1Calories, o2Calories);
        }
    };

    // Constructor
    public FoodCalculator(int numAdultMales, int numAdultFemales, int numChildrenU8, int numChildrenO8){
        this.numAdultMales = numAdultMales;
        this.numAdultFemales = numAdultFemales;
        this.numChildrenU8 = numChildrenU8;
        this.numChildrenO8 = numChildrenO8;

        calculateWholeGrainCalories();
        calculateFruitsVeggiesCalories();
        calculateProteinCalories();
        calculateOtherCalories();
        calculateTotalCalories();
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

        double cals = numAdultMales * AdultMale.getGrains()
        + numAdultFemales * AdultFemale.getGrains()
        + numChildrenU8 * ChildUnderEight.getGrains()
        + numChildrenO8 * ChildOverEight.getGrains();
 
        this.wholeGrainCalories = cals * 7;
    }

    //Calculate the total number of fruits/veggies calories needed
    public void calculateFruitsVeggiesCalories(){

        double cals = numAdultMales * AdultMale.getVeggies()
        + numAdultFemales*AdultFemale.getVeggies()
        + numChildrenU8 * ChildUnderEight.getVeggies()
        + numChildrenO8 * ChildOverEight.getVeggies();
    
        this.fruitsVeggiesCalories = cals * 7;
    }

    //Calculate the total number of protein calories needed
    public void calculateProteinCalories(){

        double cals = numAdultMales*AdultMale.getProteins()
        + numAdultFemales * AdultFemale.getProteins()
        + numChildrenU8 * ChildUnderEight.getProteins()
        + numChildrenO8 * ChildOverEight.getProteins();

        this.proteinCalories = cals * 7;
    }

    //Calculate the total number of other calories needed
    public void calculateOtherCalories(){
        double cals = numAdultMales*AdultMale.getOthers()
        + numAdultFemales * AdultFemale.getOthers()
        + numChildrenU8 * ChildUnderEight.getOthers()
        + numChildrenO8 * ChildOverEight.getOthers();

        this.otherCalories = cals * 7;
    }

    //Calculate the total number of calories needed
    public void calculateTotalCalories(){
        double cals = numAdultMales * AdultMale.getCalories()
        + numAdultFemales * AdultFemale.getCalories()
        + numChildrenU8 * ChildUnderEight.getCalories()
        + numChildrenO8 * ChildOverEight.getCalories();

        this.totalCalories = cals * 7;
    }

    // REQUIRES TESTING
    /**
     * Calculates the food combo for the hamper. 
     * Food combo calculated is the one with smallest excess.
     */
    public void calculateFoodCombos() {
        
        double[] neededCalories = {wholeGrainCalories, fruitsVeggiesCalories,
        proteinCalories, otherCalories};
        if (FoodInventory.checkShortage(neededCalories)) {
            // there is a shortage, so need to end here
            hamperFoodCombo = new ArrayList<>();
            // make hamperFoodCombo an empty arraylist
            return;
        }
        // find all possible combinations of inventory
        ArrayList<String[]> inventory = FoodInventory.getInventory();
        TreeSet<ArrayList<String[]>> testAllCombos = new TreeSet<>(ascendingHamperCalories);
        testAllCombos.addAll(allPossibleCombos(inventory));
        Iterator<ArrayList<String[]>> allCombosIterator = testAllCombos.iterator();
        // testAllCombos has sorted by least total calories, 
        // thus when usinng iterator, just need to find first one that meets all needs
        // as having least total caloreis, probably will have least excess
        while (allCombosIterator.hasNext()) {
            ArrayList<String[]> combo = allCombosIterator.next();
            if (meetAllCaloricNeeds(combo)) {
                hamperFoodCombo = new ArrayList<>(combo);
                break;
                // Make sure to stop looping as no longer need to check
            }
        }
    }
    //Below are 4 private methods that returns the difference in calories needed to fulful request and
    // current hamper contents
    private double checkRemainingGrain(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[2]);
        }
        // return the difference 
        return wholeGrainCalories - current;
    }

    private double checkRemainingVeggie(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[3]);
        }
        // return the difference 
        return fruitsVeggiesCalories - current;
    }

    private double checkRemainingProtein(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[4]);
        }
        // return the difference 
        return proteinCalories - current;
    }

    private double checkRemainingOther(TreeSet<String[]> hamper) {
        Iterator<String[]> foodIterator = hamper.iterator();
        double current = 0;
        //Sum up all grain calories currently in hamper
        while (foodIterator.hasNext()) {
            current += Double.parseDouble(foodIterator.next()[5]);
        }
        // return the difference 
        return otherCalories - current;
    }
    // private method to calculate total calories a food provides
    //  this is done by summing up calories of each type
    private double totalFoodItemCalories(String[] foodItem) {
        return Double.parseDouble(foodItem[2])
        + Double.parseDouble(foodItem[3])
        + Double.parseDouble(foodItem[4])
        + Double.parseDouble(foodItem[5]);
    }
    /**
     * Essentially returns the power set of ArrayList provided.
     * This means all possible combinations, including an empty ArrayList.
     * @param array the array whose power set will be made
     * @return the power set of array
     * @implNote this is a recursive function
     */
    public ArrayList<ArrayList<String[]>> allPossibleCombos(ArrayList<String[]> array) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
        ArrayList<ArrayList<String[]>> allCombos = new ArrayList<>();
        // Recursive function that simulates choosing and not choosing an element to make a set
        if (array.size() == 1) {
            ArrayList<String[]> e = new ArrayList<>(1);
            String[] e1 = array.get(0);
            e.add(e1);
            allCombos.add(e);

            e = new ArrayList<>();
            allCombos.add(e);

            return allCombos;
        }
        // Need to recurse but take out first element
        ArrayList<String[]> withoutFirstElement = new ArrayList<>(array);
        String[] firstElement = withoutFirstElement.remove(0);
        ArrayList<ArrayList<String[]>> returnedSets = allPossibleCombos(withoutFirstElement);
        Iterator<ArrayList<String[]>> setsIterator = returnedSets.iterator();
        while (setsIterator.hasNext()) {
            ArrayList<String[]> set = setsIterator.next();
            ArrayList<String[]> set2 = new ArrayList<>(set);
            
            set.add(firstElement); //possible set 1, element is added
            allCombos.add(set);

            allCombos.add(set2);   // possible set 2, element is not added
        }
        return allCombos;
    }
    /**
     * Checks to see if a hamper meets all requirements
     * @param currentHamper the current contents in the hamper
     * @param foodCombo the food combo to add to the currentHamper to make a test hamper 
     * to test if it meets all needs.
     * @return true if the test hamper meets all needs. False otherwise.
     */
    public boolean meetAllCaloricNeeds(ArrayList<String[]> foodCombo) {
        TreeSet<String[]> testHamper = new TreeSet<>(foodCombo);
        // Now check if not meet any requirements, if not meeting, return false
        if (checkRemainingGrain(testHamper) < 0) {
            return false;
        }
        if (checkRemainingVeggie(testHamper) < 0) {
            return false;
        }
        if (checkRemainingProtein(testHamper) < 0) {
            return false;
        }
        if (checkRemainingOther(testHamper) < 0) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        DatabaseReader.initializeConnection();
        FoodInventory foodInventory = new FoodInventory();
        FoodCalculator foodCalculator = new FoodCalculator(1, 1, 1, 1);
        //foodCalculator.calculateFoodCombos();
        DatabaseReader.close();
        ArrayList<String[]> array = new ArrayList<>(4);
        String[] e1 = {"hi"};
        String[] e2 = {"Fly"};
        String[] e3 = {"Kite"};
        String[] e4 = {"Night"};
        array.add(e1);
        array.add(e2);
        array.add(e3);
        array.add(e4);

        ArrayList<ArrayList<String[]>> c = foodCalculator.allPossibleCombos(array);
        for (int i = 0; i < c.size(); i++) {
            for (int j = 0; j < c.get(i).size(); j++) {
                System.out.print(c.get(i).get(j)[0] + "\t");
            }
            System.out.println();
        }
    }

}