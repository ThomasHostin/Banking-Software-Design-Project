# Specifications

Our goal for this project is to design a web application for artist.

This application will allow them to post their art and share it with other artist/people.
They have the possibility to accompany their art with a comment and some tags to be easily retrieve by other users.

The app will therefore propose 3 micro-services :

- A register micro-service : users will be able to create an account that will be store in a database and log into it at any time
- A posting micro-service : logged user can post arts that will be associated with possibles comment and tags
- A research micro-service : user can search for already posted art using key-words, tags and usernames.

# Technologies

The technologies we will use for this projects are the following :

For the developpement part : 

 - Angular
 - Node.js
 - Spring Boot
 - java

For the database gestion part :

 - PostgreSQL : PostgreSQL is a database gestion system that will allow us to manage the users data and their art
 - pgAdmin : pgAdmin will allow us to navigate in our database during the testing phase
