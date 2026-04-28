CREATE TABLE product (
    id          BIGINT IDENTITY(1,1) NOT NULL,
    name        VARCHAR(100)         NOT NULL,
    weight      DECIMAL(10,3)        NOT NULL,

    CONSTRAINT PK_product PRIMARY KEY (id)
);