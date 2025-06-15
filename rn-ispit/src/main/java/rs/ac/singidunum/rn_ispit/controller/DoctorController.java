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
import rs.ac.singidunum.rn_ispit.entity.Doctor;
import rs.ac.singidunum.rn_ispit.service.DoctorService;

@RestController
@RequestMapping(path = "/api/doctor")
@CrossOrigin
@RequiredArgsConstructor
public class DoctorController {
		
	private final DoctorService doctorService;
	
	@GetMapping
    public List<Doctor> getDoctor() {
        return doctorService.getDoctors();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Integer id){
    	return this.doctorService.getDoctorById(id);
    }
    
    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDoctorById(@PathVariable Integer id) {
    	this.doctorService.deleteDoctorById(id);
    }
    
    @PostMapping
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
    	return this.doctorService.saveDoctor(doctor);
    }
    
    @PutMapping
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.updateDoctor(doctor));
    }


}

	

