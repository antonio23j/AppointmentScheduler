package com.example.demoappointment.controller;

import com.example.demoappointment.entity.Appointment;
import com.example.demoappointment.model.AppointmentRequest;
import com.example.demoappointment.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AppointmentController {
    @Autowired
    AppointmentService service;

    @GetMapping("/getAppointmentsByDate")
    public List<Appointment> getAppointmentByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date){
        return service.getAppointmentsByDate(date);
    }

    @PostMapping("/createAppointment")
    public ResponseEntity<String> createAppointment(@RequestBody AppointmentRequest appointment){
        return service.createAppointment(appointment);
    }

    @PutMapping("/updateAppointment")
    public void updateAppointment(@RequestBody AppointmentRequest appointment){
        service.updateAppointment(appointment);
    }

    @DeleteMapping("/deleteAppointment")
    public void deleteAppointment(@RequestParam Integer id){
        service.deleteAppointment(id);
    }
}
