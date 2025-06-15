package rs.ac.singidunum.rn_ispit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.rn_ispit.entity.Appointment;
import rs.ac.singidunum.rn_ispit.entity.Doctor;
import rs.ac.singidunum.rn_ispit.entity.Patient;
import rs.ac.singidunum.rn_ispit.repo.AppointmentRepository;

@Service
@RequiredArgsConstructor
public class AppointmentService {
	
	private final AppointmentRepository appointmentRepository;
	private final DoctorService doctorService;
	private final PatientService patientService;

    public List<Appointment> getAppointments() {
        return appointmentRepository.findAllByDeletedAtIsNull();
    }
    
    public ResponseEntity<Appointment> getAppointmentById(Integer id){
    	return ResponseEntity.of(this.appointmentRepository.findByIdAndDeletedAtIsNull(id));
    }
    
    public void deleteAppointmentById( Integer id) {
    	Appointment a = appointmentRepository.findById(id).orElseThrow();
    	a.setDeletedAt(LocalDateTime.now());
    	this.appointmentRepository.save(a);
    }
    
    public ResponseEntity<Appointment> saveAppointment(Appointment appointment) {
    	if(appointment.getTime().isAfter(LocalDateTime.now())) {
    		return ResponseEntity.ok(appointmentRepository.save(appointment));
    	}
    	else {
    		return ResponseEntity.badRequest().build();
    	}
    }
    
    public Appointment updateAppointment(Appointment appointment) {
    	Doctor d = doctorService.getDoctorById(appointment.getDoctor().getId()).getBody();
    	Patient p = patientService.getPatientById(appointment.getPatient().getId()).getBody();
    	Appointment a = this.appointmentRepository.findById(appointment.getId()).orElseThrow();
        a.setTime(appointment.getTime());
        a.setDoctor(d);
        a.setPatient(p);
        a.setDescription(appointment.getDescription());
        
        return appointmentRepository.save(a);
    }
}
