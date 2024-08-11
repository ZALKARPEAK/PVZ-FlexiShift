package com.example.workerservice.service.impl;

import com.example.workerservice.ModelMigration.Worker;
import com.example.workerservice.ModelMigration.WorkerDto;
import com.example.workerservice.repository.WorkerRepository;
import com.example.workerservice.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;
    private final ModelMapper modelMapper;

    @Override
    public Boolean existsByEmail(String email) {
        return workerRepository.existsWorkerByEmail(email);
    }

    @Override
    public WorkerDto getWorkerByEmail(String email) {
        Optional<Worker> worker = workerRepository.getWorkerByEmail(email);
        return worker.map(workerDto -> modelMapper.map(worker, WorkerDto.class)).orElse(null);
    }

    @Override
    public void saveWorker(WorkerDto workerDto) {
        Worker worker = modelMapper.map(workerDto, Worker.class);
        workerRepository.save(worker);
    }

    @Override
    public List<WorkerDto> getAllWorker() {
        List<Worker> workers = workerRepository.findAll();
        return workers.stream().map(worker -> modelMapper.map(worker, WorkerDto.class)).collect(Collectors.toList());
    }
}
