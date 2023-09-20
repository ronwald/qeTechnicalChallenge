# qeTechnicalChallenge

**INITIAL SETUP**
1. Download and install Docker desktop
2. Run the Docker desktop
3. Save the "OppenheimerProjectDev.jar" file in your local. Note : this jar file is not in this repo
4. Run the following commands
   docker-compose -f {path-to-this-docker-file}/local-docker-compose.yml up -d
   java -Dspring.profiles.active=prd -jar {path-to-this-jar}/OppenheimerProjectDev.jar


