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

 - Angular: frontend framework worldly used to build single page application. Component based, it suits to build scalable web application. It has a collection of well-integrated libraries that cover a wide variety of features including routing, form management, client-server communication, progressive web apps and also a suite of developer tools to help you develop, build, test, and update your code via the Angular CLI.

 - Node.js: Node. js is an open source development platform for executing JavaScript code server-side. it is evented and non-blocking I/O.

 - Spring Boot: opensource java-based framework used to create micro-services.

 - java: Object Oriented Programming Language, java is platform independent that suits to a single page web application.

For the database gestion part :

 - PostgreSQL : PostgreSQL is a database gestion system that will allow us to manage the users data and their art
 - pgAdmin : pgAdmin will allow us to navigate in our database during the testing phase
