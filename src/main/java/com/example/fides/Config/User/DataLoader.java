package com.example.fides.Config.User;
import com.example.fides.Entity.User.Role;
import com.example.fides.Entity.User.User;
import com.example.fides.Repository.RoleRepository;
import com.example.fides.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepo;


    public void run(ApplicationArguments args) {
        int rolecnt = roleRepo.findAll().size();
        if(rolecnt == 0){
            String[] roleNames = {"ROLE_SUPERADMIN", "ROLE_MANAGER","ROLE_USER","ROLE_ANONYMOUS"};
            for(String roleName : roleNames){
                Role role = new Role();
                role.setName(roleName);
                roleRepo.save(role);
            }
        }   
        Boolean superExist = userRepository.findByUserId("supervisor").isPresent();
        Boolean anoExist = userRepository.findByUserId("anonymous").isPresent();
        if(!superExist){
            User user = new User();
            user.setUserId("boss");
            user.setUserName("boss");
            user.setEmail("boss@boss.com");
            user.setPassword(new BCryptPasswordEncoder().encode("Boss123"));
            Role superAdmin = roleRepo.findByName("ROLE_SUPERADMIN");
            user.setRole(superAdmin);
            userRepository.save(user);
        }
        if(!anoExist){
            User user = new User();
            user.setUserId("anonymous");
            user.setUserName("anonymous");
            user.setEmail("test@mail.com");
            user.setPassword(new BCryptPasswordEncoder().encode("password123"));
            Role anoAdmin = roleRepo.findByName("ROLE_ANONYMOUS");
            user.setRole(anoAdmin);
            userRepository.save(user);
        }

    }
}