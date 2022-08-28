package com.example.fides.AppraiserEnumModels;

import com.example.fides.Entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(callSuper = true)
public class Convertible_Securities_Evaluation extends BaseEntity {


    @Getter
    @AllArgsConstructor
    public enum SelectList {
        TF_HULL_MODEL(0),
        GOLDMAN_SACHS_MODEL(1),
        LEASE_SQUARE_MODEL(2);
        private int code;
    }

}
