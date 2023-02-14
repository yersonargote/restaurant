package com.yersonargote.restaurant.dining_room.dto;

import com.yersonargote.restaurant.dining_room.domain.EmployeeType;
import lombok.Builder;

@Builder
public record EmployeeDTO(
        String name,
        String lastName,
        String email,
        String phone,
        EmployeeType employeeType
) {
}
