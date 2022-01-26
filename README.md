# SSN-Look-Up
The SSN Look-Up program is a console based program where users are able to quickly look up the monthly benefits of a retiree. 

I used a hash table of 1024 indices with AVL trees to handle conflicts. 
An array was not used for this program. Instead, I used a hash table 
Data persistance was achedived by serializing individual AVL trees so that the entire list is never loaded into the computer at once. 


How to run the program: 
-Head to 'SSNMapApp' class and run the program. 
-You will need to first add a retiree. Follow the insturctions to add the retiree
-Once retiree has been added, you will be forwarded to the menu page
-You will then be able to retrieve the monthly benefit of the retiree by providing the SSN 
