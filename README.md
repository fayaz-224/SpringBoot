# SpringBoot

**EntityManager vs Session**
```
EntityManagerFactory and EntityManager are defined by the JPA standard
SessionFactory and Session are hibernate-specific. 

The EntityManager invokes the hibernate session under the hood. And if you need some specific features that are not available in the EntityManager, 
you can obtain the session by calling:
SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
Session session = entityManager.unwrap(Session.class);

The Session and the EntityManager translate entity state transitions into SQL statements like SELECT, INSERT, UPDATE, and DELETE.
```

**h2 database endpoint**
```
http://localhost:8080/h2-console

> H2 DB data will be lost once application stopped running.
```

**for request body to add data into DB** 
```
> No need to give id, as it is auto incremented
  we need to add one Object at a time, as we are not using list in controller

{"firstName":"jack", "lastName":"gb", "email":"s1@mail.com"}
{"firstName":"rahul", "lastName":"dk", "email":"s2@mail.com"}
{"firstName":"fin", "lastName":"ss", "email":"s3@mail.com"}
{"firstName":"mani", "lastName":"ko", "email":"s4@mail.com"}
```
