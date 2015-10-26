drop table BOOK if exists;

create table BOOK (ID integer identity primary key, CATID varchar(32), TITLE varchar(256), PUBLISHER varchar(256), AUTHOR varchar(128), ISBN varchar(16), GENRE varchar(32), AVAILABILITY varchar(32));
