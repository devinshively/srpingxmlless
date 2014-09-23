CREATE TABLE OWNER (id INTEGER auto_increment NOT NULL PRIMARY KEY, name varchar(32));
CREATE TABLE PET (id INTEGER auto_increment NOT NULL PRIMARY KEY, name varchar(32), dateBorn DATE, alive INTEGER, owner integer, constraint fk_owner foreign key (owner) references owner(id));
CREATE TABLE PICTURE ( id INTEGER auto_increment NOT NULL PRIMARY KEY, title varchar(32), description varchar(128), dateTaken date, pet integer, constraint fk_pet foreign key (pet) references pet (id) );
insert into OWNER values (1, 'Chuck Norris');
insert into PET values (1, 'Chuck', '2000-01-01', 1, 1);
insert into PICTURE values (1, 'Me gusta', 'Like a boss', '2012-05-15', 1);
insert into OWNER values (2, 'John Doe');
insert into PET values (2, 'Little ms Sunshine', '1995-02-14', 0, 2);
insert into PICTURE values (2, 'Meow', 'Aren`t I cute?', '2000-03-01', 2);