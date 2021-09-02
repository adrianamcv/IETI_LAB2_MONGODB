package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.User;
import org.ada.school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceMongoDB implements UserService{

    private final UserRepository userRepo;

    public UserServiceMongoDB(@Autowired UserRepository userRepository) {
        this.userRepo = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepo.save(user);
    }

    @Override
    public User findById(String id) {
        if (userRepo.existsById(id)){
            return userRepo.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    public List<User> all() {
        return userRepo.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        if(userRepo.existsById(id)){
            userRepo.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public User update(UserDto userDto, String id) {
        if (userRepo.existsById(id)){
            User userId = userRepo.findById(id).get();
            userId.update(userDto);
            userRepo.save(userId);
            return userId;
        }else{
            return null;
        }
    }
}
