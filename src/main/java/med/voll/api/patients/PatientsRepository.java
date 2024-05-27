package med.voll.api.patients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientsRepository extends JpaRepository<Patients, Long> {

    Page<Patients> findAllByActiveTrue(Pageable pagination);
}
