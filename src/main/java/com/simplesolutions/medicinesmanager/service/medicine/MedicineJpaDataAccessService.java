package com.simplesolutions.medicinesmanager.service.medicine;

import com.simplesolutions.medicinesmanager.exception.ResourceNotFound;
import com.simplesolutions.medicinesmanager.model.Medicine;
import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MedicineJpaDataAccessService implements MedicineDao {
    private final PatientRepository patientRepository;

    @Override
    public Medicine selectPatientMedicineById(Integer patientId, Integer medicineId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow(
                () -> new ResourceNotFound("Couldn't find Patient"));
        return patient.getPatientMedicines().get(medicineId - 1);
    }
}
