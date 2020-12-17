CREATE TABLE iF NOT EXISTS product
(
    id BIGSERIAL NOT NULL
        CONSTRAINT product_pk
            PRIMARY KEY,
    title VARCHAR NOT NULL ,
    price DOUBLE PRECISION NOT NULL ,
    added TIMESTAMP NOT NULL ,
    description text NOT NULL
);