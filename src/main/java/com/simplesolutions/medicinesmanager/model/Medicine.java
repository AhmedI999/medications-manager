package com.simplesolutions.medicinesmanager.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Medicine {
    int id;
    String brandName;
    String activeIngredient;
    int timesDaily;
    String instructions;
    List<String> interactions;
}
