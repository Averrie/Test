# TestSuite
To run this in Eclipse:

Step 1 install TestNG by go to Help->Eclipse Marketplace->Find TestNG->install

Step 2 create a new java project and import this repository

Step 3 in the project explorer drag everything from TestSuite-master to the project root folder

Step 4 add jar files by right clicking the project folder and choose property, go to the Java Build Path tab and choose Add JARs, adding all the .jar files in the project root directory

Step 5 If you are running on PC, copy and paste the chromedriver.exe to the root of your C drive, if you are running on Mac, go to http://chromedriver.storage.googleapis.com/index.html?path=2.21/ to download chromedriver for mac and put it in your desktop. Then change the second parameter of the system.setProperty to "/User/your-mac-username/Desktop/chromedriver"

Step 6 run the testSuite.java as TestNG Test
