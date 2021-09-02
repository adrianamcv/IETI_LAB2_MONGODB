package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.UserDocument;
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
    public UserDocument create(UserDocument userDocument) {
        return userRepo.save(userDocument);
    }

    @Override
    public UserDocument findById(String id) {
        if (userRepo.existsById(id)){
            return userRepo.findById(id).get();
        }else{
            return null;
        }
    }

    @Override
    public List<UserDocument> all() {
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
    public UserDocument update(UserDto userDto, String id) {
        if (userRepo.existsById(id)){
            UserDocument userDocumentId = userRepo.findById(id).get();
            userDocumentId.update(userDto);
            userRepo.save(userDocumentId);
            return userDocumentId;
        }else{
            return null;
        }
    }
}
