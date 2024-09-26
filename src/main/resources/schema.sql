drop table if exists blog;
drop table if exists author;

create table if not exists author
(
    id    serial primary key,
    name  varchar(255) not null,
    email varchar(255) not null
);

create table if not exists blog
(
    id       serial primary key,
    author_id   bigint       not null references author (id),
    title    varchar(255) not null,
    category varchar(255) not null,
    content  text         not null
);