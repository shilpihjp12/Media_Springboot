# Instructions
1. Make sure you have these installed
  - [java](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
  - [maven](https://maven.apache.org/download.cgi)
  - Postgre DB
  
 2. Clone this repository into your local machine using the terminal (mac) or Gitbash (PC) 

    `git clone https://github.com/shilpihjp12/Media_Springboot.git`
    
 3. CD to the folder

    `cd Media_Springboot`
 4. Update the proprty file application.properties for active profile.
 
 5. Update the respective active profile proprty file with Postgre connection Params. for first time server up 
    spring.jpa.hibernate.ddl-auto=create to create Tables in schema.
    
 5. Run the following to install the project dependencies:

    `mvn clean install`
 6. CD to the folder
     
     `cd Target`
 7. Run the following below command to start the server
    
    `java -jar media-Item-0.0.1-SNAPSHOT.jar`
    
 8. Add Data with DB Queries from 'Media_Springboot/data.sql' file manually to postgre db.
 
 ## Spring boot
 This project was generated with [Spring io](https://start.spring.io/).
 
