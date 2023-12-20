create table tasks
(
    id                  int auto_increment primary key,
    city                varchar(255),
    created_at          datetime,
    description         varchar(255),
    name                varchar(255),
    reporter_first_name varchar(255),
    reporter_last_name  varchar(255),
    street_with_number  varchar(255),
    user_id             int null
);

create table users
(
    id            int auto_increment primary key,
    first_name    varchar(255),
    last_name     varchar(255),
    login         varchar(255),
    password_hash varchar(255)
);