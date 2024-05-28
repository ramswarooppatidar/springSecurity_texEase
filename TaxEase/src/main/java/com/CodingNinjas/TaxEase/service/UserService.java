package com.CodingNinjas.TaxEase.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
    }

    public User createUser(UserDto userDto) {
        User newUser = new User();
        // Set properties from userDto to newUser
        newUser.setName(userDto.getName());
        newUser.setEmail(userDto.getEmail());
        // You may need to set other properties as well
        return userRepository.save(newUser);
    }

    public User updateUser(Long userId, UserDto userDto) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        // Update properties of existingUser from userDto
        existingUser.setName(userDto.getName());
        existingUser.setEmail(userDto.getEmail());
        // You may need to update other properties as well
        return userRepository.save(existingUser);
    }
}

