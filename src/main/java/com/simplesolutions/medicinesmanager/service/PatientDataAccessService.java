package com.simplesolutions.medicinesmanager.service;

import com.simplesolutions.medicinesmanager.model.Medicine;
import com.simplesolutions.medicinesmanager.model.Patient;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class PatientDataAccessService implements PatientDao{
    private static final List<Patient> patients;

    static {
        // initializing patients
        patients = new ArrayList<>();
        // adding a medicine to patient1
        Medicine patient1Medicine = new Medicine(1,
                "Furbudes",
                "Budesonide-Formoterol",
                2,
                "inhale capsule content with inhaler, wait 5 seconds and then exhale",
                List.of("aldesleukin", "mifepristone"));

        Patient patient1 = new Patient(
                1,
                "Ahmed",
                "Ibrahim",
                24,
                List.of(patient1Medicine)
        );
        // adding them
        patients.add(patient1);
    }

    @Override
    public List<Patient> selectAllPatients() {
        return patients;
    }

    @Override
    public Optional<Patient> selectPatientById(Integer id) {
        return patients.stream()
                .filter(patient -> patient.getId().equals(id))
                .findFirst();
    }
}
