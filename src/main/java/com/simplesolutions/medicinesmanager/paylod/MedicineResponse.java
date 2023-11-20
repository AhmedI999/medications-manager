package com.simplesolutions.medicinesmanager.paylod;

import com.simplesolutions.medicinesmanager.utils.StringListConverter;
import jakarta.persistence.Convert;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MedicineResponse {
    final String brandName;
    final String activeIngredient;
    final int timesDaily;
    final String instructions;
    @Convert(converter = StringListConverter.class)
    final List<String> interactions;
}
