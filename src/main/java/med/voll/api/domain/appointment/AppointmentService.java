package med.voll.api.domain.appointment;

import med.voll.api.domain.appointment.validations.AppointmentValidations;
import med.voll.api.domain.medics.Medics;
import med.voll.api.domain.medics.MedicsRepository;
import med.voll.api.domain.patients.PatientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private PatientsRepository patientsRepository;
    @Autowired
    private MedicsRepository medicsRepository;

    @Autowired
    private List<AppointmentValidations> validations;

    public DetailedAppointmentData appointment(AppointmentData data) {
        if (!patientsRepository.existsById(data.idPatient())){
            throw new RuntimeException("Patient not found");
        }
        if(data.idMedic() != null && !medicsRepository.existsById(data.idMedic())){
            throw new RuntimeException("Medical not found");
        }
        validations.forEach(v -> v.validate(data));
        var patient = patientsRepository.getReferenceById(data.idPatient());
        var medic = chooseMedic(data);
        if (medic == null) {
            throw new RuntimeException("No medic available on this date");
        }
        var appointment = new Appointment(null, medic, patient, data.date());
        appointmentRepository.save(appointment);

        return new DetailedAppointmentData(appointment);
    }

    private Medics chooseMedic(AppointmentData data) {
        if (data.idMedic() != null) {
            return medicsRepository.getReferenceById(data.idMedic());
        }

        if (data.specialty() == null) {
            throw new RuntimeException("Specialization is mandatory when choosing random medic");
        }
        return medicsRepository.chooseMedicRandomFreeOnDate(data.specialty(), data.date());
    }
}
