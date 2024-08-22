-- Database: exercicio02

-- DROP DATABASE IF EXISTS exercicio02;

-- CREATE DATABASE exercicio02
--     WITH
--     OWNER = ti2cc
--     ENCODING = 'UTF8'
--     LC_COLLATE = 'en_US.UTF-8'
--     LC_CTYPE = 'en_US.UTF-8'
--     LOCALE_PROVIDER = 'libc'
--     TABLESPACE = pg_default
--     CONNECTION LIMIT = -1
--     IS_TEMPLATE = False;

CREATE TABLE songs (
    codigo SERIAL PRIMARY KEY,
    nome TEXT NOT NULL,
    artista TEXT NOT NULL,
    genero TEXT NOT NULL
);



-- SELECT * FROM songs;
