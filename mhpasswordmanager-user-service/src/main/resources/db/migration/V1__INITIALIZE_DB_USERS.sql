DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS users_details CASCADE;
DROP TABLE IF EXISTS authorities CASCADE;
DROP TABLE IF EXISTS groups CASCADE;
DROP TABLE IF EXISTS group_authorities CASCADE;
DROP TABLE IF EXISTS group_members CASCADE;

create table users
(
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    enabled  boolean     NOT NULL,
    PRIMARY KEY (username)
);

create table authorities
(
    username  varchar(255) NOT NULL,
    authority varchar(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);
create unique index ix_auth_username on authorities (username, authority);

create table groups
(
    id         bigint GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    group_name varchar(50) NOT NULL,
    PRIMARY KEY (id)
);

create table group_authorities
(
    group_id  bigint      NOT NULL,
    authority varchar(50) NOT NULL,
    CONSTRAINT fk_group_authorities_group FOREIGN KEY (group_id) REFERENCES groups (id)
);

create table group_members
(
    id       bigint GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
    username varchar(255) NOT NULL,
    group_id bigint      NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_group_members_group FOREIGN KEY (group_id) REFERENCES groups (id)
);

CREATE TABLE users_details
(
    username  varchar(50) NOT NULL,
    firstName varchar(36) NOT NULL,
    lastName  varchar(36) NOT NULL,
    imageUrl  varchar(255),
    PRIMARY KEY (username),
    CONSTRAINT fk_user_details_users FOREIGN KEY (username) REFERENCES users (username)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
);

INSERT INTO users (username, password, enabled)
VALUES ('admin@mhpasswordmanager.com',
        '$2a$10$DoB60YPE7LytjiVBrNR7ieKkMUVB5QaIWm0gtTeOPpgSOkkNi1L3i',
        true),
       ('anonymous@mhpasswordmanager.com',
        '$2a$10$DoB60YPE7LytjiVBrNR7ieKkMUVB5QaIWm0gtTeOPpgSOkkNi1L3i',
        true);

INSERT INTO authorities (username, authority)
VALUES ('anonymous@mhpasswordmanager.com',
        'ROLE_USER'),
       ('admin@mhpasswordmanager.com',
        'ROLE_ADMIN'),
       ('admin@mhpasswordmanager.com',
        'ROLE_MASTER'),
       ('admin@mhpasswordmanager.com',
        'ROLE_USER');

INSERT INTO users_details (username, firstName, lastName, imageUrl)
VALUES ('marcoshssilva.dev@gmail.com',
        'Default',
        'Administrator',
        null),
       ('anonymous@mhpasswordmanager.com',
        'Anonymous',
        'User',
        null);