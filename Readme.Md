# Assignment 5    
Full App Functionality  
Implementation of the synchronization patterns  

Clone the project using the command git clone https://github.iu.edu/amorampu/csci50700_spring2018_marketplace.git  

cd to the src directory using the 'cd src' command in terminal  

# Running RmiRegistry and the ServerController
This MUST be run on the 10.234.136.55 computer  
To run the rmiregistry use the command rmiregistry 1895 &           
now you can run the project using the makeServer.sh file  
To start the server use the command sh makeServer.sh command  

I have added the database connection, so in the makeServer.sh file just add the path to mySQL-connector.jar file  

My makeFile looks like below, in place of the path to the connector, add your path for application to run    

javac -cp /home/amorampu/OOAD/src/mysql-connector.jar *.java  

java -cp ".:/home/amorampu/OOAD/src/mysql-connector.jar" -Djava.security.policy=policy ServerController  

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

