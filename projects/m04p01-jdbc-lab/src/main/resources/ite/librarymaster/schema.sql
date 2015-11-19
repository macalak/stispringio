drop table MEDIUM_TBL;

CREATE TABLE MEDIUM_TBL (
    id integer primary key AUTO_INCREMENT,
    dtype VARCHAR(31) NOT NULL,
    catId VARCHAR(255),
    title VARCHAR(255),
    publisher VARCHAR(255),
    author VARCHAR(255),
    genre VARCHAR(255),
    isbn VARCHAR(255),
    availability VARCHAR(255)
);


drop table USER_TBL;

CREATE TABLE USER_TBL (
    ID integer primary key AUTO_INCREMENT,
    name VARCHAR(255),
    surname VARCHAR(255),
    userState VARCHAR(255)
);

