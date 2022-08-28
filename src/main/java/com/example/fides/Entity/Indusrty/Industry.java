package com.example.fides.Entity.Indusrty;

import com.example.fides.Entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Industry extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @AllArgsConstructor
    public enum IndustryName {
        COMMERCE(0),
        FINANCIAL(1),
        EDUCATION(3);
        private int code;
    }
}
