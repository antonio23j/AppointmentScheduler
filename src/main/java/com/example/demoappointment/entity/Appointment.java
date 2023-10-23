package com.example.demoappointment.entity;

import com.example.demoappointment.model.AppointmentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime startDateTime;
    private int duration;
    private LocalDateTime endDateTime;

    public Appointment(AppointmentRequest appointmentRequest){
        this.name = appointmentRequest.getName();
        this.startDateTime = appointmentRequest.getDateTime();
        this.duration = appointmentRequest.getDuration();
        this.endDateTime = appointmentRequest.getDateTime().plusMinutes(appointmentRequest.getDuration());
    }
}
