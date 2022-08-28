package com.example.fides.Entity.User;
import com.example.fides.Entity.BaseEntity;
import com.example.fides.Entity.CrediValueInformResult.AuditorCrediValueInformResult;
import com.example.fides.Entity.File.FileEntity;
import com.example.fides.Entity.CrediValueInformation.CrediValueInformation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {
    @Id
    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String userId;

    @Size(max = 100)
    @Column(nullable = false)
    private String userName;

    @NotBlank
    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String phoneNumber;

    private String country;

    private Date dateOfBirth;

    @Size(max = 100)
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    private String businessName;

    private String businessNumber;

    private String businessType;

    private String industry;

    private String companyAddress;

    private int registrationNumber;

    private String companyName;

    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;

    @Getter
    @AllArgsConstructor
    public enum UserStatus {
        ACTIVE,
        INACTIVE,
        DELETED
    }

    @Column(nullable = true)
    private Date lastLoginDate;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<CrediValueInformation> crediValueInformationList;

    @OneToMany(mappedBy = "user")
    private List<AuditorCrediValueInformResult> auditorCrediValueInformResultList;

    @OneToMany (mappedBy = "user")
    private List<FileEntity> fileEntity;






}
