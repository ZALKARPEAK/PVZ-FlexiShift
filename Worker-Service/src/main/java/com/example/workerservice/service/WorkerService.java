package com.example.workerservice.service;

import com.example.workerservice.ModelMigration.WorkerDto;

import java.util.List;

public interface WorkerService {
    Boolean existsByEmail(String email);
    WorkerDto getWorkerByEmail(String email);
    void saveWorker(WorkerDto workerDto);
    List<WorkerDto> getAllWorker();
}