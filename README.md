# qeTechnicalChallenge

**INITIAL SETUP**
1. Download and install Docker desktop
2. Run the Docker desktop
3. Save the "OppenheimerProjectDev.jar" file in your local. Note : this jar file is not in this repo
4. Run the following commands
   docker-compose -f {path-to-this-docker-file}/local-docker-compose.yml up -d
   java -Dspring.profiles.active=prd -jar {path-to-this-jar}/OppenheimerProjectDev.jar

5. Clone this project into your local, and open the project using your IDE


**TO RUN THE TEST**
1. Simply click on the 'testng.xml' file. Select Run As>TestNG Suite

![image](https://github.com/ronwald/qeTechnicalChallenge/assets/48977986/c4ebd9ef-df82-41fa-8d20-b97e97163292)



