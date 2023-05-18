package com.rentacar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarDTO {
    private Integer id;

    private String make;

    private String model;

    private Integer year;

    private Integer mileage;

    private double price;

    private boolean available;
}
