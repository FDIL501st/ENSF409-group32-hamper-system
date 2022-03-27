package Tests;

import edu.ucalgary.ensf409.AdultFemale;
import edu.ucalgary.ensf409.AdultMale;
import edu.ucalgary.ensf409.gr32.*;
import org.junit.*;
import junit.runner.*;

public class InheritancePersonTests {
    //All the tests also check if the functions can be statically called
    
    @Before
    private void setUp() {
        AdultMale adultMale = new AdultMale(10, 20, 30, 40, 10000);
        AdultFemale adultFemale = new AdultFemale(10,20,30,40,10000);
    }
}
