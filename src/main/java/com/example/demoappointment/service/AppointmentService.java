package com.example.demoappointment.service;

import com.example.demoappointment.entity.Appointment;
import com.example.demoappointment.model.AppointmentRequest;
import com.example.demoappointment.repository.AppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository repository;

    public ResponseEntity<String> createAppointment(AppointmentRequest appointment){
        LocalDateTime start = appointment.getDateTime();
        LocalDateTime end = start.plusMinutes(appointment.getDuration());
        List<Appointment> appointments = repository.findOverlappingAppointments(start,end);
        if(!appointments.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot create appointment");
        }
        else{
            Appointment appointment1 = new Appointment(appointment);
            repository.save(appointment1);
            return ResponseEntity.ok("Appointment created successfully");
        }
    }

    public List<Appointment> getAppointmentsByDate(LocalDateTime date){
        LocalDateTime start = date.toLocalDate().atStartOfDay();
        LocalDateTime end = start.plusDays(1);
        return repository.findOverlappingAppointments(start,end);
    }
}
