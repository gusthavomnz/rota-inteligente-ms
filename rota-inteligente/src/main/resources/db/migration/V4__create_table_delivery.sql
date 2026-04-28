CREATE TABLE delivery (
    id                      BIGINT IDENTITY(1,1) NOT NULL,
    product_id              BIGINT               NOT NULL,
    cd_id                   BIGINT               NOT NULL,
    quantity                INTEGER              NOT NULL,
    distance_km             DECIMAL(10,2)        NOT NULL,
    total_shipping_value    DECIMAL(10,2)        NOT NULL,
    destination_zip_code    VARCHAR(9)           NOT NULL,
    destination_latitude    DECIMAL(10,8)        NOT NULL,
    destination_longitude   DECIMAL(11,8)        NOT NULL,
    weight_surcharge        BIT                  NOT NULL DEFAULT 0,
    created_at              DATETIME2            NOT NULL DEFAULT GETDATE(),

    CONSTRAINT PK_delivery                      PRIMARY KEY (id),
    CONSTRAINT FK_delivery_product              FOREIGN KEY (product_id) REFERENCES product(id),
    CONSTRAINT FK_delivery_distribution_center  FOREIGN KEY (cd_id)      REFERENCES distribution_center(id)
);