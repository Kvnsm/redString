CREATE SCHEMA IF NOT EXISTS portail_formation;

CREATE TABLE IF NOT EXISTS module
(
    id_module   BIGSERIAL       PRIMARY KEY,
    name        VARCHAR(200)    NOT NULL
);

CREATE TABLE IF NOT EXISTS course
(
    id_course           BIGSERIAL       PRIMARY KEY,
    name                VARCHAR(200)    UNIQUE NOT NULL,
    referee             VARCHAR(200),
    total_hour_count    BIGINT          NOT NULL,
    id_module           BIGINT          REFERENCES module(id_module) ON DELETE CASCADE
);

