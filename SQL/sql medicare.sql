
create database MediCare;
use MediCare;
create table patient(
	id int auto_increment  primary key,
	username varchar(100) unique not null,
	email varchar(100) not null,
	telephone int
);
create table medecin(
	id int auto_increment primary key,
	nom varchar(100),
	specialite varchar(100)
);
create table reservation(
	id INT AUTO_INCREMENT PRIMARY KEY,
	date_rv datetime not null,
	heure time not null,
    id_patient int,
    foreign key (id_patient) references patient(id) on delete cascade,
    id_medecin int,
    foreign key (id_medecin) references medecin(id) on delete cascade
);
show tables;
select * from medecin;
select * from patient;
select * from reservation;
drop table reservation;
alter table patient drop telephone;
alter table patient add telephone varchar (10);





