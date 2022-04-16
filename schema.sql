DROP TABLE IF EXISTS Users;

CREATE TABLE Users (
    userID INTEGER PRIMARY KEY,
    ssn CHAR(10),
    username VARCHAR(255),
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    email VARCHAR(255),
    password VARCHAR(255),
    isAdmin BOOLEAN
);