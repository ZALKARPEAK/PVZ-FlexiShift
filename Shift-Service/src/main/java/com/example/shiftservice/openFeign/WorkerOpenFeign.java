package com.example.shiftservice.openFeign;

import com.example.shiftservice.modelDto.WorkerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "Worker-Service", url = "http://localhost:9097/api/worker")
public interface WorkerOpenFeign {
    @GetMapping("/get-all-workers")
    List<WorkerDto> getAllWorker();
}