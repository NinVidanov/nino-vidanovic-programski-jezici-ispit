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
import rs.ac.singidunum.rn_ispit.entity.Patient;
import rs.ac.singidunum.rn_ispit.service.PatientService;

@RestController
@RequestMapping(path = "/api/patient")
@CrossOrigin
@RequiredArgsConstructor
public class PatientController {
		
	private final PatientService patientService;
	
	@GetMapping
    public List<Patient> getPatient() {
        return patientService.getPatient();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer id){
    	return this.patientService.getPatientById(id);
    }
    
    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePatientById(@PathVariable Integer id) {
    	this.patientService.deletePatientById(id);
    }
    
    @PostMapping
    public Patient savePatient(@RequestBody Patient patient) {
    	return this.patientService.savePatient(patient);
    }
    
    @PutMapping
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(patient));
    }


}

	