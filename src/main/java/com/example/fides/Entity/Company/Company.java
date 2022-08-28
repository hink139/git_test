package com.example.fides.Entity.Company;

import com.example.fides.Entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Company extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String companyName;

    private String address;

    private String phoneNumber;

    private String industry;

}
