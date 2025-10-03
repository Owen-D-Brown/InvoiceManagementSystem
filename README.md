# InvoiceManagementSystem

This was originally an application I built for my end of year project in Colaiste Dhulaigh in early 2024. It is a database application designed to help small businesses manage invoices. 
When I first wrote this, there was not much in the way of design and architecture - it was just a jumble of messy code that sort of worked when everything was glued together. 

As an exercise, I've decided to go back and, at the least, refactor the backend that implements JDBC to conform to a standard design pattern, and seperate the concerns of the front-end and database communications. 
I'm building the new system on a DAO pattern, with POJO classes modeled after database tables, and DTOs that combine those POJOs into usable collections for the GUI. The GUI is being refactored into an MVC pattern system. It's built on Swing - meaning it lacks the inherent Controller functionality present in JavaFX. In the future, I will take the new backend, throw out the GUI, and design a new front end for the application using JavaFX. 

**I AM IN THE PROCESS OF DECOUPLING GUI FROM OLD LOGIC - APPLICATION MAY NOT COMPILE**

Design Considerations:

Going through exception handling having refactored the database interface in the application, I realized I handled the errors terribly. All the methods just throw the error back up the callstack -
Now knowing how errors actually function, I realize they are never properly being caught. Going forward, I'll be baking exception handling explicitly into my design. 
