package com.example.fides.AppraiserEnumModels;

import com.example.fides.Entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = true)
public class Option_Evaluation extends BaseEntity {

    
    @Getter
    @AllArgsConstructor
    public enum SelectList{
        BINOMIAL_MODEL(0),
        LEASE_SQUARE_MONTE_CARLO_MODEL(1);
        private int code;
    }
}
