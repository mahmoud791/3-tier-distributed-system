# 3-tier-distributed-system
this repo is for Assignment no 1 of the distributed systems


the idea is that there is several sensors and cameras around the city which are represented by Tier_1 
these sensors collect information about there areas if there are crowdwed or empty
the send these informartion to Tier_2 through the Tier_1_2_manger class 
then Tier_2 sends these info to Tier_3 which represents a server that recomend road to drivers by opening and closing the traffic signs upon need 


to ryn the system yo have to first need the JDK installed
then open three different terminals in the "project directory/DS assign/"

in the first terminal run the command : java Tier_3    to run the central server
in the second terminal run the command : java Tier_2    to run the copmuting node
in the first terminal run the command : java Tier_1    to run the sensors


