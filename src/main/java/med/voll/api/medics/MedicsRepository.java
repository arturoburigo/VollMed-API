package med.voll.api.medics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MedicsRepository extends JpaRepository<Medics, Long> {
    Page<Medics> findAllByActiveTrue(Pageable pagination);
}
