package com.simplesolutions.medicinesmanager.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Patient {
    Integer id;
    String firstname;
    String lastname;
    int age;
    List<Medicine> patientMedicines;
    // may add more
}
