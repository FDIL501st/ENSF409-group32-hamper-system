package Tests;

import edu.ucalgary.ensf409.*;

import static org.junit.Assert.*;
import org.junit.*;

public class InheritancePersonTests {
    //All the tests also check if the functions can be statically called
    
    @Before
    public void setUp() {
        AdultMale adultMale = new AdultMale(5, 25, 30, 40, 10000);
        AdultFemale adultFemale = new AdultFemale(10,20,30,40,10000);
        ChildOverEight childOverEight = new ChildOverEight(15, 15, 35, 35, 10_000);
    }
    
    @Test
    public void AdultFemaleGettersTest() {
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

    @Test
    public void AdultMaleGettersTest() {
        // Tests if AdultMale getters return correct value
        double expected = 10_000;
        double actual = AdultMale.getCalories();
        assertEquals("Expected total calorie intake to be 10 000.", expected, actual, 0.0001);

        expected = 0.05*10_000;
        actual = AdultMale.getGrains();
        assertEquals("Expected grain intake to be 500.", expected, actual, 0.0001);

        expected = 0.25*10_000;
        actual = AdultMale.getVeggies();
        assertEquals("Expected veggie intake to be 2500.", expected, actual, 0.0001);

        expected = 0.3*10_000;
        actual = AdultMale.getProtiens();
        assertEquals("Expected veggie intake to be 3000.", expected, actual, 0.0001);

        expected = 0.4*10_000;
        actual = AdultMale.getOthers();
        assertEquals("Expected veggie intake to be 4000.", expected, actual, 0.0001);
    }
}
