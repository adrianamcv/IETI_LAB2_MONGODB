package org.ada.school.service;

import org.ada.school.dto.UserDto;
import org.ada.school.model.UserDocument;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserServiceHashMap implements UserService
{

    private final HashMap<String, UserDocument> usersMap = new HashMap<>();


    @Override
    public UserDocument create(UserDocument userDocument)
    {
        usersMap.put( userDocument.getId(), userDocument);
        return userDocument;
    }

    @Override
    public UserDocument findById(String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            return usersMap.get( id );
        }
        return null;
    }

    @Override
    public List<UserDocument> all()
    {
        return new ArrayList<>( usersMap.values() );
    }

    @Override
    public boolean deleteById( String id )
    {
        return usersMap.remove( id ) != null;
    }

    @Override
    public UserDocument update(UserDto userDto, String id )
    {
        if ( usersMap.containsKey( id ) )
        {
            UserDocument userDocument = usersMap.get( id );
            userDocument.update( userDto );
            return userDocument;
        }
        else
        {
            return null;
        }
    }


}
