create table user

(

   id integer not null auto_increment primary key,

   username varchar(255) not null,

   pass varchar(255) not null



);

create table savedstock

(

   username varchar(255) not null,

   companyname varchar(255) not null,
 
	savedstock varchar(255) not null,
    symbol varchar(255) not null
	
);


