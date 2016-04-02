# TestSuite
To run the Test Suite in Eclipse:

  * __Step 1__ install TestNG by go to Help->Eclipse Marketplace->Find TestNG->install

  *__Step 2__ create a new java project and import this repository

  *__Step 3__ in the project explorer drag everything from TestSuite-master to the project root folder

  *__Step 4__ add jar files by right clicking the project folder and choose property, go to the Java Build Path tab and choose Add JARs, adding all the .jar files in the project root directory

  *__Step 5__ If you are running on PC, copy and paste the chromedriver.exe to the root of your C drive, if you are running on Mac, go to http://chromedriver.storage.googleapis.com/index.html?path=2.21/ to download chromedriver for mac and put it in your desktop. Then change the second parameter of the system.setProperty to "/User/~~your-mac-username~~/Desktop/chromedriver"

  *__Step 6__ run the testSuite.java as TestNG Test
