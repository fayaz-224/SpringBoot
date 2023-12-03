# SpringBoot


**h2 database endpoint**
```
http://localhost:8080/h2-console

```
> H2 DB data will be lost once application stopped running.
> 
**for request body to add data into DB** 
```
we need to add one Object at a time, as we are not using list in controller

{"id":1, "firstName":"jack", "lastName":"gb", "email":"s1@mail.com"}
{"id":2, "firstName":"rahul", "lastName":"dk", "email":"s2@mail.com"}
{"id":3, "firstName":"fin", "lastName":"ss", "email":"s3@mail.com"}
{"id":4, "firstName":"mani", "lastName":"ko", "email":"s4@mail.com"}
```
