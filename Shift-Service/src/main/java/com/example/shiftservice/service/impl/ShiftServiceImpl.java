package com.example.shiftservice.service.impl;

import com.example.shiftservice.ModelMigration.Shift;
import com.example.shiftservice.enums.ShiftStatus;
import com.example.shiftservice.modelDto.WorkerDto;
import com.example.shiftservice.openFeign.WorkerOpenFeign;
import com.example.shiftservice.repository.ShiftRepository;
import com.example.shiftservice.service.ShiftService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShiftServiceImpl implements ShiftService {
    private final ShiftRepository shiftRepository;
    private final WorkerOpenFeign workerOpenFeign;

    @Scheduled(cron = "20 0 * * * *")
    public void createWeeklyShifts() {
        log.info("createWeeklyShifts() вызвана");

        LocalDate currentDate = LocalDate.now();
        LocalDate nextSunday = currentDate.with(DayOfWeek.SUNDAY).plusDays(1);

        LocalDateTime startTime = nextSunday.atTime(9, 0);
        LocalDateTime endTime = nextSunday.atTime(20, 0);

        List<WorkerDto> workers = workerOpenFeign.getAllWorker();

        for (WorkerDto worker : workers) {
            Shift shift = new Shift();
            shift.setConfirmed(false);
            shift.setStatus(ShiftStatus.NOT_RECEIVED);
            shift.setWorkerId(worker.getWorker_id());
            shift.setPickupPointId(worker.getPickup_point_id());
            shift.setStartTime(Timestamp.valueOf(startTime));
            shift.setEndTime(Timestamp.valueOf(endTime));

            log.info("Создана смена: {}", shift);
            shiftRepository.save(shift);
        }
    }

    @Override
    public ResponseEntity<Object> updateShiftStatus(Long shiftId, ShiftStatus status) {
        return null;
    }

    @Override
    public ResponseEntity<Object> sendShiftReminder(Long shiftId) {
        return null;
    }

    @Override
    public ResponseEntity<Object> suggestShiftToWorker(Long workerId, Long shiftId) {
        return null;
    }
}