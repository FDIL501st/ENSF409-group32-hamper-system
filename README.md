# ENSF409-group32-hamper-system
A program that through a GUI, lets one make hamper requests for food for a week.<p> 
You type in number of people you want the hamper to be for. Keeping a field blank means 0.
There are four types of people, each with their own caloric requirements.<br>
Adult Male, Adult Female, Child Under 8 and Child Over 8.<br>
The total number of people each hamper at most can at most accomodate for is 10 people. 10 people in total, not of each type.
<p>
By pressing "Add Another Hamper to this Request", you can make request another seperate hamper, for another at most 10 people.<br>
The fields previously typed in won't go away, so if you don't want to order food for that type of person, delete the number in that field.
<p>
When you are finally done making all the hamper requests you want to make, press "Process Hamper Request".<br>
This will then go calculate the food each hamper you requested need based off of current food availability in a database and needs of each type of person the hamper is supposed to go feed for a week.<br>
Once all your hamper reuqests have been calculated for their foods, you will get a pop up message telling you all your hampers have been processed.<br>
It will also tell you about reviewing a txt file. This txt file is the order form. It will tell you what food items each hamper has.
However, if all the hampers were unable to be completely fulfilled, then the order form will instead tell you there was a shortage. Thus none of the hampers requested in this order will be made, and no food will be provided.
From here, you can go make another order for more hampers and repeat the process above.<br>
Or press the X button of the GUI to stop the program.
