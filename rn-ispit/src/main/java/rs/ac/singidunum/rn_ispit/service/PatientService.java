package rs.ac.singidunum.rn_ispit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.rn_ispit.entity.Doctor;
import rs.ac.singidunum.rn_ispit.entity.Patient;
import rs.ac.singidunum.rn_ispit.repo.DoctorRepository;
import rs.ac.singidunum.rn_ispit.repo.PatientRepository;

@Service
@RequiredArgsConstructor
public class PatientService {

	private final PatientRepository patientRepository;
	
    public List<Patient> getPatient() {
        return patientRepository.findAllByDeletedAtIsNull();
    }
    
    public ResponseEntity<Patient> getPatientById(Integer id){
    	return ResponseEntity.of(this.patientRepository.findByIdAndDeletedAtIsNull(id));
    }
    
    public void deletePatientById( Integer id) {
    	Patient p = patientRepository.findById(id).orElseThrow();
    	p.setDeletedAt(LocalDateTime.now());
    	this.patientRepository.save(p);
    }
    
    public Patient savePatient(Patient patient) {
    	return this.patientRepository.save(patient);
    }
    
    public Patient updatePatient(Patient patient) {
    	Patient p = this.patientRepository.findById(patient.getId()).orElseThrow();
        p.setName(patient.getName());
        p.setSurname(patient.getSurname());
        p.setEmail(patient.getEmail());
        p.setPhone(patient.getPhone());
        p.setDob(patient.getDob());
        
        return patientRepository.save(p);
    }

}