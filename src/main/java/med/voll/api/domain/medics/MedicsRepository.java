package med.voll.api.domain.medics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;


public interface MedicsRepository extends JpaRepository<Medics, Long> {
    Page<Medics> findAllByActiveTrue(Pageable pagination);

    @Query("""
                select m from Medics m
                where
                m.active = true
                and
                m.specialty = :specialty
                and
                m.id not in(
                        select a.medics.id from Appointment a
                        where
                        a.date = :date
                )
                order by rand()
                limit 1
                """)
    Medics chooseMedicRandomFreeOnDate(Specialty specialty, LocalDateTime date);
}
