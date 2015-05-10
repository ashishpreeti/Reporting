create database college;
use college;
create table student (id int(30), name varchar(50), freetext varchar(80), subject varchar(100));
insert into student values ( 1, "john", "some comments here", "C#");
insert into student values ( 2, "Jane", "some comments here", "Java");
insert into student values ( 2, "Doug", "some comments here", "JavaScript");
insert into student values ( 2, "Mike", "some comments here", "Coffeescript");
commit;


create table students (studentid int(30), firstname varchar(50), lastname varchar(50), subject varchar(100));
insert into students values ( 1, "john", "Doe", "C#");
insert into students values ( 2, "Jane", "Attenborough", "Java");
insert into students values ( 2, "Doug", "Hu", "JavaScript");
insert into students values ( 2, "Mike", "Obama", "Coffeescript");
commit;

