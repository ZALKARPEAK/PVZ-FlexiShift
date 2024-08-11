package com.example.shiftservice.modelDto;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class WorkerDto {
    private Long worker_id;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private Long pickup_point_id;

    public WorkerDto() {
    }

    public WorkerDto(Long worker_id, String name, String email, String password, String phoneNumber, Long pickup_point_id) {
        this.worker_id = worker_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.pickup_point_id = pickup_point_id;
    }
}