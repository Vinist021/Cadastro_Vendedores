package com.sellers.sellers_backend.dtos;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SellerRequest {

    private Long id;

    @NotBlank(message = "Name can not be blank")
    @Size(min = 5, max=255, message = "Name length must be between 5 and 255 characters")
    private String name;

    @NotNull(message = "Salary can not be null")
    @DecimalMin(value = "0.0", message = "Salary must be at least 0")
    private Double salary;

    @NotNull(message = "Bonus can not be null")
    @DecimalMin(value = "0.0", message = "Bonus must be at least 0")
    @DecimalMax(value = "100.0", message = "Bonus must be at most 100")
    private Double bonus;

    @NotNull(message = "Gender can not be null")
    @Min(value = 0, message = "Gender must be 0 (Female) or 1 (Male)")
    @Max(value = 1, message = "Gender must be 0 (Female) or 1 (Male)")
    private Integer gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
