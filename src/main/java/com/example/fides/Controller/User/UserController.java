package com.example.fides.Controller.User;
import com.example.fides.DTO.ApiResponse;
import com.example.fides.DTO.UserDto;
import com.example.fides.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    @Autowired
    UserService userService;



    @PostMapping("/signUp")
    public ApiResponse singUp(@RequestBody UserDto.SignUp signUp){
        return userService.createUser(signUp);

    }


}
