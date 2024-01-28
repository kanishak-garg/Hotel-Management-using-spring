package com.personal.hotel.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class HotelDTO {
    @Size(min=3)
    private String name;
    @Min(value=1)
    @Max(value=10)
    private long rating;
    private String city;
}
