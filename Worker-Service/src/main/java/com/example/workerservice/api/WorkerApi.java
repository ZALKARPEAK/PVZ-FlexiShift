package com.example.workerservice.api;

import com.example.workerservice.ModelMigration.WorkerDto;
import com.example.workerservice.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/worker")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class WorkerApi {

    private final WorkerService workerService;

    @GetMapping("/existsByEmail/{email}")
    public ResponseEntity<Boolean> existsByEmail(@PathVariable String email) {
        return ResponseEntity.ok(workerService.existsByEmail(email));
    }

    @GetMapping("/getWorkerByEmail/{email}")
    public ResponseEntity<WorkerDto> getWorkerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(workerService.getWorkerByEmail(email));
    }

    @PostMapping("/saveWorker")
    public void saveWorker(@RequestBody WorkerDto workerDto){
        workerService.saveWorker(workerDto);
    }

    @GetMapping("/get-all-workers")
    public List<WorkerDto> getAllWorker() {
        return workerService.getAllWorker();
    }
}
