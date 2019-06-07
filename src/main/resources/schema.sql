
drop table if exists user_role;
drop table if exists user;
drop table if exists role;


CREATE TABLE user (
    user_id   INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    PRIMARY KEY (user_id)
);

CREATE TABLE role (
  role_id  INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(20) NOT NULL,
  PRIMARY KEY (role_id)
);

CREATE TABLE user_role (
  user_id   INTEGER NOT NULL ,
  role_id   INTEGER NOT NULL
);

/*
select * from user;
select * from role;
select * from user_role;

*/