package med.voll.api.patients;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientsRepository extends JpaRepository<Patients, Long> {

}
