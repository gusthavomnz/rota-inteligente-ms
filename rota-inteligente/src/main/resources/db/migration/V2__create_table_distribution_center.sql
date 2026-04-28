CREATE TABLE distribution_center (
    id            BIGINT IDENTITY(1,1) NOT NULL,
    name          VARCHAR(100)         NOT NULL,
    latitude      DECIMAL(10,8)        NOT NULL,
    longitude     DECIMAL(11,8)        NOT NULL,
    km_value      DECIMAL(10,2)        NOT NULL,
    dispatch_fee  DECIMAL(10,2)        NOT NULL,

    CONSTRAINT PK_distribution_center PRIMARY KEY (id)
);