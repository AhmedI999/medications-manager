package com.simplesolutions.medicinesmanager.service.patient;

import com.simplesolutions.medicinesmanager.exception.PatientAlreadyExistsException;
import com.simplesolutions.medicinesmanager.exception.ResourceNotFoundException;
import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.paylod.PatientRegistrationRequest;
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
        if (doesPatientExists(request.getEmail())) {
            throw new PatientAlreadyExistsException("Patient already Exists");
        } else {
            Patient patient = Patient.builder()
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .firstname(request.getFirstname())
                    .lastname(request.getLastname())
                    .age(request.getAge())
                    .build();
            patientDao.savePatient(patient);
        }
    }

}
