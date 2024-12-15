# PostReq - CRUD Operations in Springboot.

Database Schema - MySQL:

Create Table Users
(
	uid varchar(36) primary key,
	name varchar(100),
	email varchar(100)
);


Enpoints:

- GET ENDPOINTS:

a) Fetch All Users: 
	Endpoint: https://localhost:8080/users
	Request Body:	
		{
			"action": "FETCHALL"
		}
	Returns: ALL USERs Detail
				
b) Fetch User with given uid: 
	Endpoint: https://localhost:8080/users
	Request Body:	
		{
			"action": "FETCHBYUID",
			"uid": [UID_OF_REC_TO_BE_FETCHED]
		}
	Returns: User Details with the Particular uid				
		 
- POST ENDPOINTS:

a) Save a Single User
	Enpoint: https://localhost:8080/users
	Request Body: User Object
		{
			"name": [USERNAME],
			"email": [USEREMAIL]
		}
	Returns: Newly Created user Object
		{
			"uid": [UUID],
			"name": [USERNAME],
			"email": [USEREMAIL]
		}
		
b) Save Multiple Users at a time:
	Endpoint: https://localhost:8080/users/postAll
	Request Body: List of User objects
		[
			{
				"name": [USERNAME],
				"email": [USEREMAIL]
			},
			{
				"name": [USERNAME],
				"email": [USEREMAIL]
			}
		]
	Returns: List of Newly Created users
		[
			{
				"uid": [UUID],
				"name": [USERNAME],
				"email": [USEREMAIL]
			},
			{
				"uid": [UUID],
				"name": [USERNAME],
				"email": [USEREMAIL]
			}
		]
		
- DELETE ENDPOINT:

a) Delete Single Record:
	Endpoint: https://localhost:8080/users/delete
	Request Body:
		{
			"operation": "DELETE",
			"users": [
						{
							"uid": [USERUID],
							"name": [USERNAME],
							"email": [USEREMAIL]
						}
					]
		}
	Response: NULL
	
b) Delete Single Record with given uid:
	Endpoint: https://localhost:8080/users/delete
	Request Body:
		{
			"operation": "DELETEBYID",
			"users": [
						{
							"uid": [USERUID]
						}
					]
		}
	Response: NULL

c) Delete Multiple Records with given uid:
	Endpoint: https://localhost:8080/users/detele
	Request Body:
		{
			"operation": "DELETEALLBYUID",
			"users": [
						{
							"uid": [USERUID]
						},
						{
							"uid": [USERUID]
						},
						{
							"uid": [USERUID]
						}
					]
		}
	Response: NULL
	
d) Delete Multiple Records with given details:
	Endpoint: https://localhost:8080/users/delete
	Request Body:
		{
			"operation": "DELETEALL",
			"users": [
						{
							"uid": [USERUID],
							"name": [USERNAME],
							"email": [USEREMAIL]
						},
						{
							"uid": [USERUID],
							"name": [USERNAME],
							"email": [USEREMAIL]
						},
						{
							"uid": [USERUID],
							"name": [USERNAME],
							"email": [USEREMAIL]
						}
					]
		}
	Response: NULL
	
- PUT ENDPOINT:

a) Replace an existing user with another:
	Endpoint: https://localhost:8080/users
	Request Body:
		{
			"uid": [USERUID],
			"name": [USERNAME],
			"email": [USEREMAIL]
		}
	Response: Replace user details:
		{
			"uid": [USERUID],
			"name": [USERNAME],
			"email": [USEREMAIL]
		}
		
- PATCH ENDPOINT:

a) Update an existing User:
	Endpoint: https://localhost:8080/users
	Request Body: field to be updated for user with given uid.
		{
			"uid": [USERUID],
			"name": [USERNAME]
		}
	Response: Updated User details
		{
			"uid": [USERUID],
			"name": [USERNAME],
			"email": [USEREMAIL]
		}			 

