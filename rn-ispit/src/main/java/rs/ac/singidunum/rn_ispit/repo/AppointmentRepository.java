package rs.ac.singidunum.rn_ispit.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rs.ac.singidunum.rn_ispit.entity.Appointment;
import rs.ac.singidunum.rn_ispit.entity.Doctor;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer>{

	List<Appointment> findAllByDeletedAtIsNull();
	
	Optional<Appointment> findByIdAndDeletedAtIsNull(Integer id);

	Boolean existsByIdAndDeletedAtIsNull(Integer id);
	
}
