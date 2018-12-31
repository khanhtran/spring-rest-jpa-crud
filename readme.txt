Simple CRUD REST app using SpringBoot/JPA
Main class: com.sample.curdapp.Application
APIs:
1- POST localhost:8080/api/user: create new user
	Sample input: {
					"name":"Max",
					"city":"Fairfield",
					"phone":"6419801361",
					"email":"max@email.com"
				}
2. POST localhost:8080/api/technology: create new technology
	Sample input:
		{
		    "name": "C++",
		    "active": true
		}
		
3. POST http://localhost:8080/api/user-tech?userId=&technologyId= create new user-tech
4. PUT http://localhost:8080/api/user/{userId}: update user
5. PUT localhost:8080/api/technology/{techId}: update technology
6. PUT localhost:8080/api/user-tech/8?userId=xxx&technologyId=yyy: update user tech
7. DELETE http://localhost:8080/api/user/{userId}: delete user
8. DETETE http://localhost:8080/api/technology/{technologyId}: delete technology
9. DETETE http://localhost:8080/api/user-tech/{Id}: delete user-technology
10. GET http://localhost:8080/api/user/fetchUsers?techId=xxx: fetch list of users by a given techid
11. GET http://localhost:8080/api/user/getusers?pageSize=1&pageNum=2: get user with paging
12. GET http://localhost:8080/api/technology/gettechnologies?pageSize=1&pageNum=2: get technologies with paging