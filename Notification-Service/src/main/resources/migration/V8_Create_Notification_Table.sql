CREATE TABLE Notifications (
                               notification_id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                               notification_type VARCHAR(30) NOT NULL, --'booking_confirmation', 'shift_reminder', 'penalty', 'bonus'
                               message TEXT NOT NULL,
                               shift_id BIGINT,
                               worker_id BIGINT,
                               manager_id BIGINT,
                               is_sent BOOLEAN DEFAULT FALSE,
                               sent_at Timestamp,
                               FOREIGN KEY (shift_id) REFERENCES Shift(shift_id),
                               FOREIGN KEY (worker_id) REFERENCES Worker(worker_id),
                               FOREIGN KEY (manager_id) REFERENCES Worker(worker_id)
);