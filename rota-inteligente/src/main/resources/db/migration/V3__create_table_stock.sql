CREATE TABLE stock (
    id          BIGINT IDENTITY(1,1) NOT NULL,
    product_id  BIGINT               NOT NULL,
    cd_id       BIGINT               NOT NULL,
    quantity    INTEGER              NOT NULL,

    CONSTRAINT PK_stock                        PRIMARY KEY (id),
    CONSTRAINT UQ_stock_product_cd             UNIQUE      (product_id, cd_id),
    CONSTRAINT FK_stock_product                FOREIGN KEY (product_id) REFERENCES product(id),
    CONSTRAINT FK_stock_distribution_center    FOREIGN KEY (cd_id)      REFERENCES distribution_center(id)
);