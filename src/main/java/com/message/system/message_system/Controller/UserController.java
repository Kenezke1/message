package com.message.system.message_system.Controller;


import com.message.system.message_system.Model.User;
import com.message.system.message_system.Service.UserService;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public User findById(@RequestParam("id") Integer userId) throws UserNotFoundException {
        return userService.findById(userId);
    }

    @PutMapping("")
    public void editUser(@RequestBody User newUser) throws UserNotFoundException {
        userService.editUser(newUser);
    }

    @PatchMapping("")
    public void editStatus(@RequestParam("userId") Integer userId,
                           @RequestParam("status") String status) throws UserNotFoundException {
        userService.editStatus(userId,status);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestBody Integer userId) throws UserNotFoundException {
        userService.deleteUser(userId);
    }
}
