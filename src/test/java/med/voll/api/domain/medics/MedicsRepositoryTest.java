package med.voll.api.domain.medics;

import med.voll.api.domain.address.AddressData;
import med.voll.api.domain.appointment.Appointment;
import med.voll.api.domain.patients.PatientRegisterData;
import med.voll.api.domain.patients.Patients;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class MedicsRepositoryTest {
    @Autowired
    private MedicsRepository medicsRepository;

    @Autowired
    private TestEntityManager em;

    @Test
    @DisplayName("Should return null when unique medic registered is not available on date")
    void chooseMedicRandomFreeOnDateScene1() {
        var nextSundayAt10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medic  = registerMedic("Medic", "medic@voll.med", "123456", Specialty.CARDIOLOGY);
        var patient = registerPatient("Patient", "patient@email.com", "00000000000");
        registerAppointment(medic, patient, nextSundayAt10);

        var freeMedic = medicsRepository.chooseMedicRandomFreeOnDate(Specialty.CARDIOLOGY, nextSundayAt10);
        assertThat(freeMedic).isNull();

    }

    @Test
    @DisplayName("Should return medic registered is available on date")
    void chooseMedicRandomFreeOnDateScene2() {
        var nextSundayAt10 = LocalDate.now()
                .with(TemporalAdjusters.next(DayOfWeek.MONDAY))
                .atTime(10, 0);

        var medic  = registerMedic("Medic", "medic@voll.med", "123456", Specialty.CARDIOLOGY);

        var freeMedic = medicsRepository.chooseMedicRandomFreeOnDate(Specialty.CARDIOLOGY, nextSundayAt10);
        assertThat(freeMedic).isEqualTo(medic);

    }

    private void registerAppointment(Medics medics, Patients patients, LocalDateTime data) {
        em.persist(new Appointment(null, medics, patients, data));
    }

    private Medics registerMedic(String name, String email, String crm, Specialty specialty) {
        var medics = new Medics(medicsRegisterData(name, email, crm, specialty));
        em.persist(medics);
        return medics;
    }

    private Patients registerPatient(String name, String email, String cpf) {
        var patient = new Patients(patientRegisterData(name, email, cpf));
        em.persist(patient);
        return patient;
    }

    private MedicsRegisterData medicsRegisterData(String name, String email, String crm, Specialty especialidade) {
        return new MedicsRegisterData(
                name,
                email,
                "61999999999",
                crm,
                especialidade,
                addressData()
        );
    }

    private PatientRegisterData patientRegisterData(String name, String email, String cpf) {
        return new PatientRegisterData(
                name,
                email,
                "61999999999",
                cpf,
                addressData()
        );
    }

    private AddressData addressData() {
        return new AddressData(
                "rua xpto",
                "bairro",
                "SP",
                "88813150",
                "606",
                null,
                "Centro"
        );
    }
}