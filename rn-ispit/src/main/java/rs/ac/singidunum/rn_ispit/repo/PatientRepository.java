package rs.ac.singidunum.rn_ispit.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.rn_ispit.entity.Doctor;
import rs.ac.singidunum.rn_ispit.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer>{

	List<Patient> findAllByDeletedAtIsNull();
	
	Optional<Patient> findByIdAndDeletedAtIsNull(Integer id);

	Boolean existsByIdAndDeletedAtIsNull(Integer id);
	
	
}
