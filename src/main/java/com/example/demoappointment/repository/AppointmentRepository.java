package com.example.demoappointment.repository;

import com.example.demoappointment.entity.Appointment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    @Query("FROM Appointment WHERE\n" +
            "startDateTime BETWEEN ?1 AND ?2 OR \n" +
            "endDateTime BETWEEN ?1 AND ?2 OR\n" +
            "?1 BETWEEN startDateTime AND endDateTime")
    public List<Appointment> findOverlappingAppointments(LocalDateTime start, LocalDateTime end);
}
