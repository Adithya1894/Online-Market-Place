# Assignment 2  
Implementation of RMI, MVC, Command Pattern  
Abstract Factory, Front Controller for the online MarketPlace application  

Clone the project using the command git clone https://github.iu.edu/amorampu/csci50700_spring2018_marketplace.git  

cd to the src directory using the 'cd src' command in terminal  

# Running RmiRegistry and the ServerController
This MUST be run on the 10.234.136.57 computer  
To run the rmiregistry use the command rmiregistry 1895 &   
open another instance of the same computer(10.234.136.57)        
now you can run the project using the makeServer.sh file  
To start the server use the command sh makeServer.sh command

# Running Client

To run the client open any other pegasus terminal and use the makeClient.sh file.  

use sh makeClient.sh to run the client.  

# Terminating ServerController and the Registry
To do this you need to first Terminate the server, do this using "cmd + c" in MAC    
use fg to bring the registry to foreground  
Terminate the Registry in the same way using "cmd + c" in MAC  

# Passwords for logging in

Admin details  
Id: admin  
pass: 12345  

Customer Details  
Id: amorampu  
pass: 1234  

# Demonstrating RBAC  
Login to Admin Method using the Above credentials  
select option 1 to see the working RBAC for Admin  
select option 5 "purchase Items" this should deny access      

# Domain Model

&nbsp;
&nbsp;
&nbsp;
&nbsp;



![alt text](/Images/Domain.png "Domain Model")  
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;
&nbsp;

# Class Diagram 
&nbsp;
&nbsp;
&nbsp;
&nbsp;


![alt text](/Images/class.png "Class Diagram")

