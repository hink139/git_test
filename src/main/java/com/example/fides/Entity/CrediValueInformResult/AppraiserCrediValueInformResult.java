package com.example.fides.Entity.CrediValueInformResult;


import com.example.fides.Entity.BaseEntity;
import com.example.fides.Entity.CrediValueInformation.CrediValueInformation;
import com.example.fides.Entity.User.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AppraiserCrediValueInformResult extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "credi_value_information_id")
    private CrediValueInformation crediValueInformation;

    private String processStatus;        // 00, 99

    private String processStage;         // 10~70

    private String volatilityCalFileName;

    private String volatilityCalStatus;

    private String spotInterestRateFileName;

    private String spotInterestRateStatus;

    private String cashFlowAndDebtValCalFileName;

    private String cashFlowAndDebtValCalStatus;

    private String blackDermanToyCalFileName;

    private String blackDermanToyCalStatus;

    private String refixingCalFileName;

    private String refixingCalStatus;






}
