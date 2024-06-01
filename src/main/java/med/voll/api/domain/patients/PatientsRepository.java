package med.voll.api.domain.patients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patients, Long> {

    Page<Patients> findAllByActiveTrue(Pageable pagination);
}
