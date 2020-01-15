create table Person (
   id integer not null ,
   name varchar(255) not null,
   location varchar (255),
   birth_date timestamp,
   primary key(id)
);

insert into person (id , name , location , birth_date) values (1002 , 'ran' , 'Delhi' , sysdate());

insert into person (id , name , location , birth_date) values (1004 , 'shyam' , 'Hydrabad' , sysdate());

insert into person (id , name , location , birth_date) values (1006 , 'ramesh' , 'Lonavla' , sysdate());

insert into person (id , name , location , birth_date) values (1007 , 'kartik' , 'Gurgaon' , sysdate());