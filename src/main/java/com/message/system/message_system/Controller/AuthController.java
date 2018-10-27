package com.message.system.message_system.Controller;

import com.message.system.message_system.Model.User;
import com.message.system.message_system.Service.UserService;
import com.message.system.message_system.exceptions.EmailAlreadyExistsException;
import com.message.system.message_system.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public User login(@RequestBody String email) throws UserNotFoundException {
        return userService.findByEmail(email);
    }

    @PostMapping("/register")
    public User register(@RequestParam("first_name") String firstName,
                         @RequestParam("last_name") String lastName,
                         @RequestParam("email") String email,
                         @RequestParam("image") String image) throws EmailAlreadyExistsException {
        return userService.addUser(firstName,lastName,email,image);
    }
}
