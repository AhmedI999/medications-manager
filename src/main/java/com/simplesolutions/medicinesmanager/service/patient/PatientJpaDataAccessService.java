package com.simplesolutions.medicinesmanager.service.patient;

import com.simplesolutions.medicinesmanager.exception.ResourceNotFound;
import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Repository
public class PatientJpaDataAccessService implements PatientDao {
    private final PatientRepository patientRepository;
    @Override
    public List<Patient> selectAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> selectPatientById(Integer id) {
        return Optional.of(patientRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("patient with id (%s) not found".formatted(id))));
    }
}
