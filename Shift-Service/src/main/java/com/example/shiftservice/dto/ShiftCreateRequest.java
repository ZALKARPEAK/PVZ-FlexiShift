package com.example.shiftservice.dto;

import com.example.shiftservice.enums.ShiftStatus;

import java.sql.Timestamp;

public class ShiftCreateRequest {
    private Timestamp startTime;
    private Timestamp endTime;
    private boolean isConfirmed;
    private ShiftStatus status;
}