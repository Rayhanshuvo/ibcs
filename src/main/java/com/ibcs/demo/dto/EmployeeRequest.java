package com.ibcs.demo.dto;

import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private Long id;
    @Pattern(regexp = "\\d{4}", message = "Employee ID should be 4 digits")
    private String employeeId;
    private String name;
    private String address;
    private String mobile;
    private Long gradeId;
    private Long bankAccountId;
}
