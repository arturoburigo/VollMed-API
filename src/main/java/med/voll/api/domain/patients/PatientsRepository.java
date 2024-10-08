package med.voll.api.domain.patients;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientsRepository extends JpaRepository<Patients, Long> {

    Page<Patients> findAllByActiveTrue(Pageable pagination);

    @Query("""
                select p.active from Patients p
                where p.id = :id
                """)
    Boolean findActiveById(long id);
}
