package com.message.system.message_system.Service;

import com.message.system.message_system.Model.User;
import com.message.system.message_system.exceptions.EmailAlreadyExistsException;
import com.message.system.message_system.exceptions.UserNotFoundException;

public interface UserService {

    User findById(Integer id)throws UserNotFoundException;

    User findByEmail(String email) throws UserNotFoundException;

    User addUser(String firstName, String lastName, String email, String image) throws EmailAlreadyExistsException;

    void editStatus(Integer userId, String newStatus) throws UserNotFoundException;

    void editUser(User user) throws UserNotFoundException;

    void deleteUser(Integer userId)throws UserNotFoundException;
}
