# **Opera application**

This project represents itself as web based system, which can be used by opera theatres as an online service.Their clients can check schedule, buy tickets and reserve their seats for performance there.
It is developed on the stack of Hibernate and Spring on the principles of SOLID, and it has N-tier architecture with DataBase, DAO, Service, Controllers and View layers. Its functions are authentication and authorization with the help of roles. There is a UML diagram below with relationship between entities and access level description of the relevant role.

![alt text](https://i.postimg.cc/6QNkZ9wN/Career-Planning-Mind-Map.png)

## **Main functions:**

- **Guest (without any role)**
  - registration
  - authentication and authorization
  - view of all available performances
  - view of all stages at the opera theatre
  - search of relevant performance sessions by date

- **User**
  - all endpoints of the guest are available
  - adding of the ticket for performance to the shopping cart
  - view of all the tickets in the shopping cart
  - processing order
  - view of history of all the orders

- **Admin**
  - all endpoints of the guest are available
  - ability to edit schedule
  - adding of new performances
  - opening and closure of new stages
  - revealing information about user by e-mail

## **Technologies used**

- Spring - Core / MVC / Web / Security
- Hibernate
- RDBMS - MySQL
- Packaging - Apache Maven
- Tomcat
- JSON

## **Configuration:**

- Сlone this project into your local folder and open the project in an IDE.
- Setup new connection with
  - user: "your username"
  - password: "your password"
  - url: jdbc:mysql://xxxx:yyyy/zzzz?serverTimezone=UTC , where: 
    - xxxx - host name,
    - yyyy - port,
    - zzzz - database name
    
- Run a project