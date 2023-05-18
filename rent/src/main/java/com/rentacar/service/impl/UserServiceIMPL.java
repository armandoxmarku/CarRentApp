package com.rentacar.service.impl;

import com.rentacar.dto.User.UserDTO;
import com.rentacar.dto.User.UserUpdateDTO;
import com.rentacar.entity.User;
import com.rentacar.entity.UserRole;
import com.rentacar.exeption.ResourceNotFountException;
import com.rentacar.mapper.UserMapper;
import com.rentacar.repository.UserRepository;
import com.rentacar.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.String.format;


@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDTO registerUser(UserDTO req, String userRole) {
        User u = UserMapper.toEntity(req);
        u.setRole(userRole!=null? UserRole.fromValue(userRole):UserRole.ADMIN);
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        u = userRepository.save(u);
        return UserMapper.toDto(u);
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email).get();
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    @Override
    public UserUpdateDTO updateUser(Integer id, UserUpdateDTO req) {
        User u = findById(id);
        u = UserMapper.buildUpdateUser(u,req);
        return UserMapper.toUpdateDto(userRepository.save(u));
    }


    @Override
    public User findById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFountException(String
                        .format("User with id %s not found",id)));
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException(
                                format("User with username - %s, not found", email)));
    }
}
