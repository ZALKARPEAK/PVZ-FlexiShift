CREATE TABLE Worker (
                        worker_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        phone_number VARCHAR(255) NOT NULL,
                        pickup_point_id BIGINT,
                        CONSTRAINT fk_pickup_point
                            FOREIGN KEY (pickup_point_id)
                                REFERENCES PickupPoint(pickup_point_id_id)
);