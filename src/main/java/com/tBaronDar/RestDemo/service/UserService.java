package com.tBaronDar.RestDemo.service;

import com.tBaronDar.RestDemo.model.User;
import com.tBaronDar.RestDemo.model.UserPrincipal;
import com.tBaronDar.RestDemo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Merged UserDetailService and UserService
 * from the security exercise in to this project
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo ur;
    private BCryptPasswordEncoder encoder= new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return ur.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = ur.findByUsername(username);
        if (u == null) {
            throw new UsernameNotFoundException("User 404");
        }
        //below is step 4
        return new UserPrincipal(u);
    }
}