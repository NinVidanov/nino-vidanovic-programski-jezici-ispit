package rs.ac.singidunum.rn_ispit.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ProblemDetail;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.rn_ispit.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer>{

	List<Doctor> findAllByDeletedAtIsNull();
	
	Optional<Doctor> findByIdAndDeletedAtIsNull(Integer id);

	Boolean existsByIdAndDeletedAtIsNull(Integer id);

}
