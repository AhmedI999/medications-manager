package com.simplesolutions.medicinesmanager.service;

import com.simplesolutions.medicinesmanager.model.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PatientService {
    private final PatientDao patientDao;
    public List<Patient> getAllCustomers(){
        return patientDao.selectAllPatients();
    }
    public Patient getPatientById(Integer id){
        return patientDao.selectPatientById(id).orElseThrow(() ->
                new IllegalArgumentException("Patient with id [%s] not found".formatted(id)));
    }
}
