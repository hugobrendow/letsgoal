CREATE TABLE authorities (
    authority_id integer CONSTRAINT pk_authority_id PRIMARY KEY,
    role varchar(30) NOT NULL
);

CREATE TABLE users (
   user_id integer CONSTRAINT pk_user_id PRIMARY KEY,
   username varchar(30) NOT NULL,
   password varchar(30) NOT NULL,
   accountNonExpired boolean,
   accountNonLocked boolean,
   credentialsNonExpired boolean
);

CREATE TABLE user_authority (
   user_id integer NOT NULL,
   authority_id integer NOT NULL,
   PRIMARY KEY (user_id, authority_id),
   CONSTRAINT fk_user
       FOREIGN KEY(user_id)
           REFERENCES users(user_id),
   CONSTRAINT fk_role
       FOREIGN KEY(authority_id)
           REFERENCES authorities(authority_id)
);