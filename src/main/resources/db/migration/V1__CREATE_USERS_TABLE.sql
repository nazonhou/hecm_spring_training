create table if not exists users (
    id serial primary key,
    username varchar not null unique,
    email varchar not null unique,
    created_at timestamp not null
);