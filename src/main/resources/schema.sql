--we can create table from entity class itself or using these .sql files
--Note: these .sql file has to be in resources, otherwise we need to explicitly mention path in application.prop
--spring.datasource.schema=classpath:Schemafile-location
--spring.datasource.data=classpath:Datafile-location

create table person(
    id int not null AUTO_INCREMENT,
    name varchar(10),
    age int,
    primary Key(id)
);