package com.example.fides.Service;

import com.example.fides.DTO.ApiResponse;
import com.example.fides.DTO.UserDto;
import com.example.fides.Entity.User.User;

public interface UserService {

    public ApiResponse createUser (UserDto.SignUp signUp);

    public ApiResponse updateUser ();

    public ApiResponse deleteUser ();
    public ApiResponse changePassword  ();

    public ApiResponse forgotPassword ();

    public ApiResponse searchById (Long id);

    public void lastLogin(User user);
}
