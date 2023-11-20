package com.simplesolutions.medicinesmanager.service.medicine;

import com.simplesolutions.medicinesmanager.model.Medicine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MedicineService {
    private final MedicineDao medicineDao;
    public Medicine getPatientMedicineById(Integer patientId, Integer medicineId){
        return medicineDao.selectPatientMedicineById(patientId, medicineId);
    }
}
