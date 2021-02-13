




Dependencies:
* Appium Desktop 
    * Set url to 127.0.0.1 and port to  4723
* Java SDK 8
* Download app apk and set the route on de.verivox.driversSetUp.BaseSetup.java
* Check and set your android/iOS version on de.verivox.driversSetUp.BaseSetup.java




Run the test:
* Install Maven to run the tests ( brew install maven)
* go into the project directory
* execute in command line 
    * mvn clean test
    
    In case the report is not in the target folder please install allure
    brew install allure
    
    and run the following command 
    allure serve target/surefire-reports
    
    


