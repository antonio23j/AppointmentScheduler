package com.example.demoappointment.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AppointmentRequest {

    private String name;
    private LocalDateTime dateTime;
    private int duration;
}
