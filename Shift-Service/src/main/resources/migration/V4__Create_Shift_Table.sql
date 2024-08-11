CREATE TABLE Shift (
                       id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                       start_time TIMESTAMP NOT NULL,
                       end_time TIMESTAMP NOT NULL,
                       is_confirmed BOOLEAN NOT NULL,
                       pickup_point_id BIGINT,
                       worker_id BIGINT,
                       status smallint,
                       CONSTRAINT fk_pickup_point FOREIGN KEY (pickup_point_id) REFERENCES PickupPoint(id),
                       CONSTRAINT fk_worker FOREIGN KEY (worker_id) REFERENCES Worker(id)
);