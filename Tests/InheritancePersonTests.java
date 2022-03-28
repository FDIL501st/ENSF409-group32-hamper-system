package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;

public class InheritancePersonTests {
    //All the tests also check if the functions can be statically called
    
    @Before
    public void setUp() {
        AdultMale adultMale = new AdultMale(10, 20, 30, 40, 10000);
        AdultFemale adultFemale = new AdultFemale(10,20,30,40,10000);
    }

    @Test
    public void AdultFemaleGetters() {
        // Tests if getters return the correct value
        double expected = 1000;
        double actual = AdultFemale.getGrains();
        assertEquals("Expected grains intake to be 1000.",expected, actual, 0.0001);

        expected = 2000;
        actual = AdultFemale.getVeggies();
        assertEquals("Expected veggies intake to be 2000.", expected, actual, 0.0001);

        expected = 3000;
        actual = AdultFemale.getProtiens();
        assertEquals("Expected protiens intake to be 3000.", expected, actual, 0.0001);

        expected = 4000;
        actual = AdultFemale.getOthers();
        assertEquals("Expected others intake to be 4000.", expected, actual, 0.0001);

        expected = 10000;
        actual = AdultFemale.getCalories();
        assertEquals("Expected total calorie intake to be 10 000.", expected, actual, 0.0001);
    }
}
