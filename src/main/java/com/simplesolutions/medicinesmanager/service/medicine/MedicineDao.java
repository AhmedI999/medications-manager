package com.simplesolutions.medicinesmanager.service.medicine;

import com.simplesolutions.medicinesmanager.model.Medicine;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineDao {

    Medicine selectPatientMedicineById(Integer patientId, Integer medicineId);

}
