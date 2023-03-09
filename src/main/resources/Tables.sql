--h2 is typically used to setup a test database, not a prod database.
--first, drop your tables (to reset your database for testing)
--then create your tables
create table if not exists Author (id integer AUTO_INCREMENT, first_name VARCHAR(255), last_name varchar(255),PRIMARY Key(id));

 create table  if not exists Book ( isbn  integer primary key not null, author_id integer,Title varchar(255),
 copies  integer,  FOREIGN KEY (author_id) REFERENCES Author(id)
 );
