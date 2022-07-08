# Web Service Project Sample
This project was implemented whit the intent of practice concepts and stacks well used in the market. During the project i was able to learn new things and also consolidate the concepts that i had already practiced.

Whit this Web Service app you can creat, read, update and delete Users to a store. This User also has layers assigned to him, such as:
- Order (The Order has also an Payment layer) and Product (who has an Catagory layer). Between these two theres also a Order Item and Order Status layer.

# Deployment
The app was deployed in the Heroku and you can test all the features using Postman whit this url: https://chaves-webservice-project.herokuapp.com/

# Implementation
The project was implemented using a domin model, structured in logical layers such as: Resources (REST Controllers), Service and Data Access, everything communicating with the Entities of the project.

# Stacks
The project was build whit Springboot, JPA/Hibernate and Postgres as database. The database testing was made using H2. 
