# SpringBootRestApiValidations
This project is built to explain the CRUD operations using SpringBoot Rest API and also we have performed validations for entity fields of database table. 
Use the below URLs to perform CRUD Operations,

i) Post-> Create Entry-- Use POST end point
	localhost:9393/api/shop/signup
	Body Payload:
	{
   	  "acctID": "1",
	"custName": "Supreeth",
	"city": "Hyderabad",
	"state": "TS",
	"country": "India",
	"phoneNo": "12345",
	"password": "Supreeth123"
	}

ii) GetAll-Use GET endpoint
     Get all -> localhost:9393/api/mypage/fetchAll

iii)GET user details by id-Use GET Endpoint
    localhost:9393/api/mypage/1

iv)Update user details if id exists->Use PUT endpoint
   localhost:9393/api/mypage/1

v)Delete user details using userId->Use DELETE endpoint
   localhost:9393/api/mypage/1
================================
UI Setup (Need to install Vs code and node)
1.Go to path PS D:\springboot\client\my-app> 
2.execute command "npm run start"
example:PS D:\springboot\client\my-app> npm run start
