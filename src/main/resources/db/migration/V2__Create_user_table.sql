CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL UNIQUE,
                       password VARCHAR(100) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_user FOREIGN KEY(username) REFERENCES users(username)
);

INSERT INTO users (username, password, enabled) VALUES
    ('user', '{bcrypt}$2a$10$EheWyqarHycc57Qeyb4lreEYmAJmCHWcxUdeOsvneweTbK0LAWpYi', true);

INSERT INTO authorities (username, authority) VALUES ('user', 'ROLE_USER');

INSERT INTO users (username, password, enabled) VALUES
    ('admin', '{bcrypt}$2a$10$PltRxPHic/Wp/ELGGnOKaOOIDfpYVl2kTkOsB.dbBiNGwTpBbTjWK', true);

INSERT INTO authorities (username, authority) VALUES ('admin', 'ROLE_ADMIN');



