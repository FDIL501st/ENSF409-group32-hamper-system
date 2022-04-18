/**
 * <h1>HamperTest</h1>
 * Project for ENSF 409
 * <p>
 * @author Group 32
 * @version 1.5
 * @since 1.0
 */

package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

/* Tests for the Hamper Class */

public class HamperTest{

    // Test that the hamper is constructed appropriately with the right numbers of people
    @Test
    public void hamperConstructorTest(){
        int expectedNumAdultMales = 3;
        int expectedNumAdultFemales = 1; 
        int expectedNumChildrenU8 = 0;
        int expectedNumChildrenO8 = 4;

        Hamper hamp = new Hamper(expectedNumAdultMales, expectedNumAdultFemales, expectedNumChildrenU8, expectedNumChildrenO8);

        int actualNumAdultMales = hamp.getNumAdultMales();
        int actualNumAdultFemales = hamp.getNumAdultFemales();
        int actualNumChildrenU8 = hamp.getNumChildrenU8();
        int actualNumChildrenO8 = hamp.getNumChildrenO8();

        assertEquals("Incorrect number of Adult Males", expectedNumAdultMales, actualNumAdultMales);
        assertEquals("Incorrect number of Adult Females", expectedNumAdultFemales, actualNumAdultFemales);
        assertEquals("Incorrect number of Children Under 8", expectedNumChildrenU8, actualNumChildrenU8);
        assertEquals("Incorrect number of Children Over 8", expectedNumChildrenO8, actualNumChildrenO8);
    }

    // Test that a hamper returns a non null Food Calculator object
    @Test
    public void hamperFoodCalculatorGetterTest() {
        Hamper hamp = new Hamper(1,1,1,1);
        FoodCalculator calc = hamp.getFoodCalculator();
        assertNotNull("The hamper did not create a FoodCalculator object", calc);
    }
}
