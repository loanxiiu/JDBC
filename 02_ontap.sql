-- create database ontap
-- character set utf8mb4
-- collate utf8mb4_unicode_ci

use ontap;
create table Person(
	person_id int not null auto_increment,
    last_name varchar(20),
    first_name varchar(20),
    gender varchar(255),
    dod date,
    income double,
    primary key (person_id)
);

alter table Person change dod dob int;

insert into Person(person_id, last_name, first_name, gender, dob, income) 
values
(1, "Nguyen", "Loan", "nu", null, 2000.5),
(2, "Nguyen", "Loan", "nu", null, 2000.5);

select * from Person;

update Person set first_name = "Khang" where person_id = 2;

SET SQL_SAFE_UPDATES = 0;

update Person 
set income = income + 500 
Where first_name ="Loan";

delete from Person where last_name = "Nguyen";

delete  from Person where first_name = "Khang";

