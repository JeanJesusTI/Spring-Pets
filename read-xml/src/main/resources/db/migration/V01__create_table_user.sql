CREATE TABLE user(
    id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    login VARCHAR(200),
    password VARCHAR(200),
    admin BOOLEAN default 0
);

INSERT INTO user(login, password, admin)
    values ('adminUser','$2a$10$cwkva5VMK0paNWFpyEbjkuy9guEb7E8u0hubNokLIQJkkIRPpdnie',1);
