package com.example.fides.DTO;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


public class UserDto {



    @Data
    public static class SignUp{
        @NotEmpty
        private String userId;
        @NotEmpty
        private String userName;
        @NotEmpty
        private String phoneNumber;
        @NotEmpty
        private String password;
        @NotEmpty
        private String businessName;
        @NotEmpty
        private String industry;
        @NotEmpty
        private String companyAddress;
        @Email
        private String email;
        @NotEmpty
        private String registrationNumber;
    }

    @Data
    public static class SignIn{

    }

}
