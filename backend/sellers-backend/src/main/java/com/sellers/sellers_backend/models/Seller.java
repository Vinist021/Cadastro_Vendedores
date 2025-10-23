package com.sellers.sellers_backend.models;

import static jakarta.persistence.GenerationType.IDENTITY;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "sellers")
public class Seller {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Length(min = 5, max=255, message = "Name length must be between 5 and 255 characters")
    private String name;

    @Column(name = "salary", nullable = false)
    @DecimalMin(value = "0.0", message = "Salary must be at least 0")
    private Double salary;

    @Column(name = "bonus", nullable = false)
    @DecimalMin(value = "0.0", message = "Bonus must be between 0 and 100")
    @DecimalMax(value = "100.0", message = "Bonus must be between 0 and 100")
    private Double bonus;

    @Column(name = "gender", nullable = false)
    @Min(value = 0, message = "Gender must be 0 (Female) or 1 (Male)")
    @Max(value = 1, message = "Gender must be 0 (Female) or 1 (Male)")
    private Integer gender;

    public Seller() {
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Seller other = (Seller) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
