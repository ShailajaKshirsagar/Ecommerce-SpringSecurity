package com.ecommerce.serviceImpl;

import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepo;
import com.ecommerce.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceImpl implements CustomUserService, UserDetailsService
{

    @Autowired
    private UserRepo userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String saveUser(User user) {
        //here we need to encrypt the password
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User saved successfully with username : " + user.getUsername();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if(user!=null) {
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getUsername())
                    .password(user.getPassword())
                    .roles(user.getRoles().stream()
                            .map(User.ROLES::name)
                            .toArray(String[]::new))
                    .build();
        }
        throw new UsernameNotFoundException("User name not found with the given username");
    }

    //update
    @Override
    public void updatePassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }

}
