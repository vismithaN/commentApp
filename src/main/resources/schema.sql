create table user (email_id varchar(255) not null, password varchar(255), secret_code varchar(255), primary key (email_id));
create table comments (id integer not null, comment text, user_id varchar(255), primary key (id));
alter table comments add constraint FK_Comments foreign key (user_id) references user;