create database java_library_system;

use java_library_system;


insert into users (id, username,`password`, usertype) values (NULL,'u_admin', 'pass', 'admin');
create table book_genres 
(
	id int primary key auto_increment,
    name nvarchar(200)
    
);

create table author
(
	id int primary key auto_increment,
    name nvarchar (100),
    expertise nvarchar (200),
    about text 
);
create table member
(
	id int primary key auto_increment,
    name nvarchar (100),
    phone varchar(30),
    email text,
    gender varchar(25),
    picture longblob
);

create table book
(
	isbn varchar (25) primary key,
    name nvarchar (250),
    author_id int,
    genre_id int,
    quantity int,
    publisher nvarchar (250),
    price double,
    date_received date,
    description text,
    cover_image longblob,
     CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES author(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES book_genres(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);

-- alter table book add constraint fk_author_id foreign key(author_id) references author(id) on update cascade on DELETE cascade;
-- alter table book add CONSTRAINT fk_genre_id FOREIGN KEY (genre_id) REFERENCES book_genres(id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE;
        
        
alter table book drop primary key;
alter table book add id int not null auto_increment first, add primary key(id);
alter table book add unique(isbn);

SELECT author_id FROM book
WHERE author_id NOT IN (SELECT id FROM author);

create table issue_book 
(
	book_id int,
    member_id int,
    status nvarchar (50) ,
    issue_date date,
    return_date date,
    note text,
    CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES book(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE,
	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member(id)
        ON UPDATE CASCADE
        ON DELETE CASCADE
);
 -- alter table issue_book add CONSTRAINT fk_book_id FOREIGN KEY (book_id) REFERENCES book(id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE;
--  alter table issue_book add	CONSTRAINT fk_member_id FOREIGN KEY (member_id) REFERENCES member(id)
--         ON UPDATE CASCADE
--         ON DELETE CASCADE;
create table users_table 
(
	id int primary key auto_increment,
    name nvarchar(100),
    username varchar(100),
    password varchar(100),
    user_type nvarchar(20)
);




