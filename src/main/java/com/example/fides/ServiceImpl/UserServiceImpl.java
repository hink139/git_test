package com.example.fides.ServiceImpl;
import com.example.fides.DTO.ApiResponse;
import com.example.fides.DTO.UserDto;
import com.example.fides.Entity.User.User;
import com.example.fides.Repository.RoleRepository;
import com.example.fides.Repository.UserRepository;
import com.example.fides.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    @Override
    public ApiResponse createUser(UserDto.SignUp signUp) {
        ApiResponse response = new ApiResponse();
        String encryptedPass = "";
        Boolean exist = userRepository.existsByUserId(signUp.getUserId());
        if(exist){
            response.setStatusCode(403);
            response.setMessage("user.id.exist");
            return response;
        }
        User user = new User();

        user.setUserId(signUp.getUserId());
        user.setUserName(signUp.getUserName());
        String password = signUp.getPassword();
        encryptedPass = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encryptedPass);
        user.setRole(roleRepository.findByName("ROLE_USER"));
        user.setEmail(signUp.getEmail());
        userRepository.save(user);
        response.setStatusCode(200);
        response.setMessage("SUCCESSFULLY USER SAVED");

        return response;
    }


    @Override
    public void lastLogin(User user) {
        user.setLastLoginDate(new Date());
        userRepository.save(user);
    }

    @Override
    public ApiResponse updateUser() {
        return null;
    }

    @Override
    public ApiResponse deleteUser() {
        return null;
    }

    @Override
    public ApiResponse changePassword() {
        return null;
    }

    @Override
    public ApiResponse forgotPassword() {
        return null;
    }

    @Override
    public ApiResponse searchById(Long id) {
        return null;
    }
}
