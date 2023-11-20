package com.simplesolutions.medicinesmanager.controller;

import com.simplesolutions.medicinesmanager.model.Medicine;
import com.simplesolutions.medicinesmanager.model.Patient;
import com.simplesolutions.medicinesmanager.paylod.MedicineResponse;
import com.simplesolutions.medicinesmanager.paylod.PatientResponse;
import com.simplesolutions.medicinesmanager.service.medicine.MedicineService;
import com.simplesolutions.medicinesmanager.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    private final MedicineService medicineService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }
    @GetMapping("/{patientId}")
    public ResponseEntity<PatientResponse> getPatient(@PathVariable("patientId") Integer id) {
        Patient patient = patientService.getPatientById(id);
        return ResponseEntity.ok(new PatientResponse(patient.getEmail(), patient.getFirstname()
                , patient.getLastname(),patient.getAge(), patient.getPatientMedicines()));
    }
    @GetMapping("/{patientId}/medicines/{medicineId}")
    public ResponseEntity<MedicineResponse> getMedicine(@PathVariable("patientId") Integer patientId,
                                                        @PathVariable("medicineId") Integer medicineId){
        Medicine medicine = medicineService.getPatientMedicineById(patientId, medicineId);
        return ResponseEntity.ok(new MedicineResponse(medicine.getBrandName(), medicine.getActiveIngredient(),
                medicine.getTimesDaily(), medicine.getInstructions(), medicine.getInteractions()));
    }
}

