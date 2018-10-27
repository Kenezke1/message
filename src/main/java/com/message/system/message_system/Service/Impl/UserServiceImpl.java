package com.message.system.message_system.Service.Impl;

import com.message.system.message_system.Model.Status;
import com.message.system.message_system.Model.User;
import com.message.system.message_system.Repository.UserRepository;
import com.message.system.message_system.Service.UserService;
import com.message.system.message_system.exceptions.EmailAlreadyExistsException;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }

        throw new UserNotFoundException("User with this ID is not present!");
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }

        throw new UserNotFoundException("User with this email not present!");

    }

    @Override
    public User addUser(String firstName, String lastName, String email, String image) throws EmailAlreadyExistsException {
        if(userRepository.findByEmail(email).isPresent()){
            throw new EmailAlreadyExistsException("User with this email already exists!");
        }

        User newUser = User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .image(image)
                .status("ONLINE")
                    .build();

        return userRepository.saveAndFlush(newUser);

    }

    @Override
    public void editStatus(Integer userId, String newStatus) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            user.get().setStatus(Status.valueOf(newStatus));
        }
        else {
            throw new UserNotFoundException("User with this ID not present!");
        }
    }

    @Override
    public void editUser(User user) throws UserNotFoundException {
        Optional<User> oldUser = userRepository.findById(user.getId());
        if(!oldUser.isPresent()){
            throw new UserNotFoundException("User with this ID not found!");
        }
        userRepository.saveAndFlush(edit(oldUser.get(),user));


    }

    @Override
    public void deleteUser(Integer userId) throws UserNotFoundException {
        userRepository.deleteById(userId);
    }


    private User edit(User oldUser,User newUser){
        Field[] fields = User.class.getDeclaredFields();
        for (Field field: fields){
            try {
                if(!field.get(oldUser).equals(field.get(newUser))){
                    field.set(oldUser,field.get(newUser));
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return oldUser;
    }
}
