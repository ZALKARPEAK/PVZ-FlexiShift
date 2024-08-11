package com.example.shiftservice.service;

import com.example.shiftservice.enums.ShiftStatus;
import org.springframework.http.ResponseEntity;

public interface ShiftService {
    /**
     * Возвращает график смен для заданного ПВЗ и периода.
     *
     * @param posId      ID ПВЗ.
     * @param dateRange  Период, для которого требуется получить график смен.
     * @return График смен в виде списка объектов Shift.
     */
/*
    List<Shift> getShiftCalendar(Long posId, LocalDate dateRange);
*/

    /**
     * Изменяет статус смены (открыто/закрыто).
     *
     * @param shiftId    ID смены.
     */
    ResponseEntity<Object> updateShiftStatus(Long shiftId, ShiftStatus status);

    /**
     * Отправляет уведомление о смене работнику.
     *
     * @param shiftId ID смены.
     */
    ResponseEntity<Object> sendShiftReminder(Long shiftId);

    /**
     * Возвращает список работников, доступных для работы на смене, с учетом типа смены и требуемых навыков.
     *
     * @param posId           ID ПВЗ.
     * @param shiftType       Тип смены.
     * @param date            Дата смены.
     * @param requiredSkills  Требуемые навыки для работы на смене.
     * @return Список работников, доступных для работы на смене.
     */
/*
    List<Worker> getAvailableWorkers(Long posId, ShiftType shiftType, LocalDate date, List<String> requiredSkills);
*/

    /**
     * Отправляет предложение о работе на смену работнику.
     *
     * @param workerId ID работника.
     * @param shiftId  ID смены.
     */
    ResponseEntity<Object> suggestShiftToWorker(Long workerId, Long shiftId);
}