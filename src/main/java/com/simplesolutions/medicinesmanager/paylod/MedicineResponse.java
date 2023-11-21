package com.simplesolutions.medicinesmanager.paylod;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.simplesolutions.medicinesmanager.utils.StringListConverter;
import jakarta.persistence.Convert;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MedicineResponse {
    // todo constraints might not be needed
    @NotBlank(message = "Brand name is required")
    final String brandName;
    final String activeIngredient;
    @NotBlank(message = "times medicine is taken daily required")
    final int timesDaily;
    @NotBlank(message = "For your safety, instructions are required")
    final String instructions;
    @Convert(converter = StringListConverter.class)
    final List<String> interactions;
}
