package com.example.shiftservice.api;

import com.example.shiftservice.service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/shift")
@RequiredArgsConstructor
public class ShiftApi {

    private final ShiftService shiftService;

}