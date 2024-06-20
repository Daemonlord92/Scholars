package org.blitmatthew.dto;

import java.math.BigDecimal;

public record EmployeeDto(
        Long id,
        String firstName,
        String lastName,
        BigDecimal salary,
        Long phone
) {
}
