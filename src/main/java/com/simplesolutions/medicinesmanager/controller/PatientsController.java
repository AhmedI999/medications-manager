package com.simplesolutions.medicinesmanager.controller;

import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/demo/patients")
@RequiredArgsConstructor
public class PatientsController {
    private final PatientService patientService;

    @GetMapping("/")
    public List<Patient> getAllPatients() {
        return patientService.getAllCustomers();
    }

    @GetMapping("/{patientId}")
    public Patient getPatient(@PathVariable("patientId") Integer id) {
        return patientService.getPatientById(id);
    }
}

