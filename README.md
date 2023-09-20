# qeTechnicalChallenge

**INITIAL SETUP**
1. Download and install Docker desktop
2. Run the Docker desktop
3. Save the "OppenheimerProjectDev.jar" file in your local.
   Note : Due to size constraing, this jar file is not in this repo
5. Run the following commands from your terminal :
   a. docker-compose -f {path-to-this-docker-file}/local-docker-compose.yml up -d
   b. java -Dspring.profiles.active=prd -jar {path-to-this-jar}/OppenheimerProjectDev.jar
   Note : You may need to open the terminal as administrator before running the java command.

6. Clone this project into your local, and open the project using your IDE




**TO RUN THE TEST**
1. Simply click on the 'testng.xml' file. Select Run As>TestNG Suite

![image](https://github.com/ronwald/qeTechnicalChallenge/assets/48977986/c4ebd9ef-df82-41fa-8d20-b97e97163292)





**SOME IMPORTANT INFO ABOUT THE TEST PROJECT**

1. The testdata are storeed in the DataProviders.java class, using TestNG @DataProviders annotation
   ![image](https://github.com/ronwald/qeTechnicalChallenge/assets/48977986/8451a441-e942-4893-8e6d-139f266a8a1d)

2. For UserStory2.java, the testdata are stored in the "hero.csv", and "heroUnsuccessful.csv"
3. Make sure the application is run using "Dspring.profiles.active=prd " property, otherwise, records  will not be saved in the database
