drop table MEDIUM_TBL if exists;
drop table USER_TBL if exists;

create table MEDIUM_TBL (ID integer identity primary key, CATID varchar(32), TITLE varchar(256), PUBLISHER varchar(256), AUTHOR varchar(128), ISBN varchar(16), GENRE varchar(32), AVAILABILITY varchar(32));
create table USER_TBL (ID integer identity primary key, NAME varchar(256), SURNAME varchar(256), USERSTATE varchar(32));
