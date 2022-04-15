CREATE TABLE IF NOT EXISTS passports
(
    id         SERIAL PRIMARY KEY NOT NULL,
    number     INT                NOT NULL UNIQUE,
    series     INT                NOT NULL UNIQUE,
    name       VARCHAR(20)        NOT NULL,
    surname    VARCHAR(20)        NOT NULL,
    validity   DATE               NOT NULL
    );