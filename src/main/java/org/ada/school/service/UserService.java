package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.UserDocument;

import java.util.List;

public interface UserService
{
    UserDocument create(UserDocument userDocument);

    UserDocument findById(String id );

    List<UserDocument> all();

    boolean deleteById( String id );

    UserDocument update(UserDto userDto, String id );
}
