CREATE TABLE Penalty (
                         penalty_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                         worker_id BIGINT NOT NULL,
                         shift_id BIGINT,
                         reason TEXT NOT NULL,
                         penalty_type VARCHAR(20) NOT NULL, --'account_block', 'rating_decrease', 'fine'
                         penalty_value INT NOT NULL,
                         applied_at Timestamp NOT NULL,
                         FOREIGN KEY (worker_id) REFERENCES Worker(worker_id),
                         FOREIGN KEY (shift_id) REFERENCES Shift(shift_id)
);