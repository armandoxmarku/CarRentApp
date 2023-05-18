package com.rentacar.service;

import com.rentacar.dto.User.UserDTO;
import com.rentacar.dto.User.UserUpdateDTO;
import com.rentacar.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {
    public UserDTO registerUser(UserDTO req, String userRole);
    UserUpdateDTO updateUser(Integer id, UserUpdateDTO req);
    public User loginUser(String email, String password);
    public User findById(Integer id);
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
