package rs.ac.singidunum.rn_ispit.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.rn_ispit.entity.Appointment;
import rs.ac.singidunum.rn_ispit.service.AppointmentService;

@RestController
@RequestMapping(path = "/api/appointment")
@RequiredArgsConstructor
@CrossOrigin
public class AppointmentController {
	
	private final AppointmentService appointmentService;
	
	@GetMapping
    public List<Appointment> getAppointment() {
        return appointmentService.getAppointments();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Integer id){
    	return this.appointmentService.getAppointmentById(id);
    }
    
    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAppointmentById(@PathVariable Integer id) {
    	this.appointmentService.deleteAppointmentById(id);
    }
    
    @PostMapping
    public ResponseEntity<Appointment> saveAppointment(@RequestBody Appointment appointment) {
    	return this.appointmentService.saveAppointment(appointment);
    }
    
    @PutMapping
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment) {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointment));
    }

}
