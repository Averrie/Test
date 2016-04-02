# TestSuite
To run the Test Suite in Eclipse:

   __Step 1__  
   Install TestNG by go to Help->Eclipse Marketplace->Find TestNG->Install

   __Step 2__  
   Create a new java project, download this repository as zip and import it as Archive File

   __Step 3__  
   In the project explorer drag everything from TestSuite-master to the project root folder, you may delete the TestSuite-master folder after you move the files
   
   __Step 4__  
   Add jar files by right clicking the project folder and choose properties, go to the Java Build Path tab and choose Add JARs, adding all the .jar files in the project root directory

   __Step 5__  
   If you are running on PC, copy and paste the chromedriver.exe to the root of your C drive, if you are running on Mac, go to http://chromedriver.storage.googleapis.com/index.html?path=2.21/ and download chromedriver for mac and put it in your desktop. Then change the second parameter of the system.setProperty to "/Users/~~your-mac-username~~/Desktop/chromedriver"

   __Step 6__  
   Run testSuite.java as TestNG Test
