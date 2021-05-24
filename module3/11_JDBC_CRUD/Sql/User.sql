create database demo;

USE demo;

create table users (
 id  int(3) NOT NULL AUTO_INCREMENT,
 `name` varchar(120) NOT NULL,
 email varchar(220) NOT NULL,
 country varchar(120),
 PRIMARY KEY (id)
);

insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');

select * from users ;

update users 
set `name`="Duc Toan",email="toan@gmail.com",country="USA"
where id=3;

SET  information_schema_stats_expiry=10;


SELECT AUTO_INCREMENT
FROM information_schema.TABLES
WHERE TABLE_SCHEMA = "demo"
AND TABLE_NAME = "users";



SHOW TABLE STATUS FROM `demo` WHERE `name` LIKE 'users' ;

-- SELECT AUTO_INCREMENT 
-- FROM information_schema.tables
-- WHERE table_name = 'users' and table_schema = 'demo';

DELIMITER $$
CREATE PROCEDURE show_all_users () 
 BEGIN
  SELECT * FROM users;
END $$
DELIMITER ;

call show_all_users ();

DELIMITER $$
CREATE PROCEDURE edit_user (in `name_edit` varchar(120), in email_edit varchar(120),in country_edit varchar(120),in id_edit int(3))
 BEGIN
	update users 
	set `name`=name_edit,  email=email_edit,  country=country_edit
	where id=id_edit;
END $$
DELIMITER ;

call edit_user("temo","temo@gmail.com","Viet Nam",9);


DELIMITER $$
CREATE PROCEDURE delete_user (in id_edit int(3))
 BEGIN
	delete from users 
	where id=id_edit;
END $$
DELIMITER ;

call delete_user(8)
