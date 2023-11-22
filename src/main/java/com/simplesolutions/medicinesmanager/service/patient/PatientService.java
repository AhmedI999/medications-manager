package com.simplesolutions.medicinesmanager.service.patient;

import com.simplesolutions.medicinesmanager.exception.DuplicateResourceException;
import com.simplesolutions.medicinesmanager.exception.PatientUpdateException;
import com.simplesolutions.medicinesmanager.exception.ResourceNotFoundException;
import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.paylod.PatientRegistrationRequest;
import com.simplesolutions.medicinesmanager.paylod.PatientUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {
    private final PatientDao patientDao;
    public List<Patient> getAllPatients(){
        return patientDao.selectAllPatients();
    }
    public Patient getPatientById(Integer id){
        return patientDao.selectPatientById(id).orElseThrow(() ->
                new ResourceNotFoundException("patient with id [%s] not found".formatted(id)));
    }
    public boolean doesPatientExists(String email) {
        return patientDao.doesPatientExists(email);
    }

    public void savePatient(PatientRegistrationRequest request){
        if (doesPatientExists(request.getEmail()))
            throw new DuplicateResourceException("Patient already Exists");
            Patient patient = Patient.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .age(request.getAge())
                    .build();
            patientDao.savePatient(patient);

    }
    public void deletePatient(Integer id){
            patientDao.deletePatientById(id);
    }
    public void editPatientDetails(Integer id, PatientUpdateRequest request){
        Patient patient = getPatientById(id);
        boolean changes = false;
        if (patient == null) {
            throw new ResourceNotFoundException("Patient doesn't exist");
        }
        if (request.getEmail() != null && !request.getEmail().equals(patient.getEmail())) {
            if (patientDao.doesPatientExists(request.getEmail())) {
                throw new DuplicateResourceException(
                        "email already taken"
                );
            }
            patient.setEmail(request.getEmail());
            changes = true;
        }
        if (request.getFirstname() != null && !request.getFirstname().equals(patient.getFirstname())) {
            patient.setFirstname(request.getFirstname());
            changes = true;
        }

        if (request.getLastname() != null && !request.getLastname().equals(patient.getLastname())) {
            patient.setLastname(request.getLastname());
            changes = true;
        }
        if (!changes) {
            throw new PatientUpdateException("no data changes found");
        }
        patientDao.updatePatient(patient);
    }
}
