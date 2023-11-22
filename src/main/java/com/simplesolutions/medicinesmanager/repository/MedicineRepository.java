package com.simplesolutions.medicinesmanager.repository;

import com.simplesolutions.medicinesmanager.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer> {
    boolean existsMedicineByBrandName(String brandName);
    Optional<Medicine> findByPatientIdAndId(Integer patientId, Integer medicineId);
}
