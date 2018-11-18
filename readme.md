

# Tax Calculator

Welcome to the repository of **Tax Calculator**!

Tax calculator is a REST microservice created using Spring Boot 2 and Java 8 which accepts JSON payload and implements the following objectives,

<Write a program in java to calculate tax as per below mentioned income slab tax rates.>


Income Tax Slab - Tax Rate
==========================
Up to Rs.2,00,000 | No Tax
Rs.2,00,000 to Rs.5,00,000 | 10%
Rs.5,00,000 to Rs.10,00,000 | 20%
Rs.10,00,000 and beyond | 30%

Note :
    - Program should support for multiple nations.
    - Use proper naming conventions
    - Use design patterns if required

Input :- Salary & Country
Output :- Tax Amount.

Request JSON format:

{
	"salary": 9000000,
	"country": "india"
}

Response JSON format:

{
    "tax": 2700000
}

