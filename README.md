# CalculatorProject

This is a simple calculator Api with front end written in React.js 
Author: Kristjan Erik Ruubel

# Backend

Simple spring boot api built with gradle.
Uses H2 in memory database to store calculations in memory.
That means everytime application is restarted memory is cleaned.

Supported functions are 

request url = "http:localhost:8080/hello"
returns Hello World!

request url = "http:localhost:8080/calculate" with json body {"num1": number one,"op": operand ,"num2": second number}
returns json {"calculationResult": result}

request url = "http:localhost:8080/getResults" 
returns all previous calculations done in programm runtime

request url = "http:localhost:8080/calculate?num1=numberone&num2=secondnumber&op=operand" 
returns json {"calculationResult": result}

Supported Operands: "sum", "div", "sub", "prod"

Cors is implemented on port 3000 so front end should run on port 3000.

Time ran litte short, didnt have time to implement intregration tests.

Bootable jar is located in github projects main directory.


# Frontend

Frameworks used in Front end are React.js and Fetch api to perform api requests.

Default setting is Addition function to select different function use button toolbar.

Calculation history is implemented by collide component.

Result field of the calculator is immutable, Result of calculation is displayed there.

All Api requests are implemented on port 8080 so back end should run on port 8080










