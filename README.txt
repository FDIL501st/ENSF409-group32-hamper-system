# ENSF409 Final Project
------------------------

This program allows a Food Bank to generate the optimum combinations of food items from their available inventory to fulfill requests for hampers for families to sustain them for 1 week. The user is able to enter hamper requests of varying configurations of family members through the GUI. The program will generate form indicating either that the request was fulfilled and will list off the items needed for each hamper or it will report the shortage that caused the request to not be fulfilled.

- - - - - - - - - - - - - - - - - - - - - - - -

To Run the Program:

Download the ENSF409_FinalProject zip file from D2L. Unzip the file and navigate to the working directory in your computer through your terminal.

Ensure that the MySQL connector jar file is present in your lib folder in the directory. Then compile the files using the following command (Note that this is the command for the Terminal in Mac, it may vary in a different operating system or terminal program.):

	javac -cp .:lib/mysql-connector-java-8.0.23.jar:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar edu/ucalgary/ensf409/*.java

Ensure that the database is present on your computer. The main is contained in the file GUIHamperSystem.java. Run the program using the following command:

	java -cp .:lib/mysql-connector-java-8.0.23.jar:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar edu/ucalgary/ensf409/GUIHamperSystem


The input required in the GUI is the number of adult males, adult females, children under 8, and children over 8 up to a maximum of 10 people per family. If a field in the GUI is left blank, a 0 will be assumed.  You may add another hamper to the request by clicking "Add Another Hamper to this Request". Note that the fields are not cleared and so you must overwrite each field with the new family configuration for the new hamper.

When you are done adding hampers, click "Process Hamper Request." Please wait patiently for the algorithm to perform the calculations. When it is done, the program will notify you. Review the text file created in the working directory to see the result of the request. If it is successful, the items required for each hamper will be listed. If it was not successful, the caloric shortage will be reported instead.

You may either enter another hamper request as before or press the X button of the GUI to stop the program.

Note: The DatabaseReader.java class has the database access username and password hardcoded in. The username is "student" and the password is "ensf".

- - - - - - - - - - - - - - - - - - - - - - - -

To Run the Tests:

Ensure that the Hamcrest Core jar file, and the Junit jar file are present in your lib folder in the directory. Then compile the files using the following command (Note that this is the command for the Terminal in Mac, it may vary in a different operating system or terminal program.):

	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar edu/ucalgary/ensf409/*.java

Run the tests using the following command:

	java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.FILENAME

Here, FILENAME is a placeholder for the name of the file containing the tests. The test files are listed here:

	FoodCalculatorTest
	FoodInventoryTests
	GeneralTest
	HamperRequestTest
	HamperTest
	InheritancePersonTests
	OrderFormTests

