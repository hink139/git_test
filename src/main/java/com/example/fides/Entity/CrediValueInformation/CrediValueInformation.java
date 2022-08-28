package com.example.fides.Entity.CrediValueInformation;


import com.example.fides.Entity.BaseEntity;
import com.example.fides.Entity.User.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class CrediValueInformation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Boolean isListed;

    private String evaluationModel1;

    private String evaluationModel2;

    private String method;

    private String itemName;

    private Date issueDate;

    private Double issuePrice;

    private Date interestRatePeriod;

    private Date interestRatePaymentStart;

    private String evaluationBaseDate;

    private Date dueDate;

    private Double parInterestRate;

    private Double guaranteed;

    private Date conversionStartDate;

    private Double conversionEndDate;

    private Date eventStartDate;

    private Date evenEndDate;

    private Date stepMonth;

    private Date startDate; // ?????

    //BlackDermanToyCalculationInput

    private String UnderlyingAssetCreditRating;

    private Date volatilityCalculationPeriod;

    private Double annualizedVolatility;

    //RefixingCalculationInput

    private Double refixingUpperLimit;

    private Double refixingLowerLimitAmount;

    private Date refixingStartDate;

    private Date refixingCycle;

    private String refixingConditions;

    //SpotInterestRateCalculationInput

    private String fundamentalAssetCreditRating;

    private Date naturalExpiration;

    private Double ytm;

    private Double riskFreeRate;

    //VolatilityCalculationInput

    private String SearchStocksUnderlyingAssets;

    private Double volatilityOutlierCalculation;

    private Date volatilityCalculation;







}
