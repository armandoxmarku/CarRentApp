package com.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentalDTO {
    private Integer id;
    private Integer user_Id;
    private Integer car_Id;
    private LocalDate startDate;
    private LocalDate endDate;
}
