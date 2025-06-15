package rs.ac.singidunum.rn_ispit.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.rn_ispit.entity.Doctor;
import rs.ac.singidunum.rn_ispit.repo.DoctorRepository;

@Service
@RequiredArgsConstructor
public class DoctorService {

	private final DoctorRepository doctorRepository;
	
    public List<Doctor> getDoctors() {
        return doctorRepository.findAllByDeletedAtIsNull();
    }
    
    public ResponseEntity<Doctor> getDoctorById(Integer id){
    	return ResponseEntity.of(this.doctorRepository.findByIdAndDeletedAtIsNull(id));
    }
    
    public void deleteDoctorById( Integer id) {
    	Doctor d = doctorRepository.findById(id).orElseThrow();
    	d.setDeletedAt(LocalDateTime.now());
    	this.doctorRepository.save(d);
    }
    
    public Doctor saveDoctor(Doctor doctor) {
    	System.out.println(doctor);
    	return this.doctorRepository.save(doctor);
    }
    
    public Doctor updateDoctor(Doctor doctor) {
    	Doctor d = this.doctorRepository.findById(doctor.getId()).orElseThrow();
        d.setName(doctor.getName());
        d.setSurname(doctor.getSurname());
        d.setEmail(doctor.getEmail());
        d.setPhone(doctor.getPhone());
        d.setDob(doctor.getDob());
        
        return doctorRepository.save(d);
    }

}
