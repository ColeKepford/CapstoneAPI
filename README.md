# HailMaryAPI
Before using make sure you have mysql ready to go because this uses the database, it does not make it
It also requires release 1.9 and above, im personally using 15

For setting up mySQL I used MySQL Workbench, i created a connection called HailMary, make sure its port 3306 and username is 
root and password is password. Find the tab Schemas, right click and Create schema, name it nexgenfinancial and click apply near the bottom.
Algorithm and Lock type i didnt mess with.  Once created it should appear in the Schemas tab. Above the navigator find the Open sql script 
button and select the UPDATEDcreate_ngf.sql file from github. Click the lightning bolt once loaded. Right click nexgenfinancial and click 
Refresh all. Repeat process for UPDATEDconstraints_ngf.sql
