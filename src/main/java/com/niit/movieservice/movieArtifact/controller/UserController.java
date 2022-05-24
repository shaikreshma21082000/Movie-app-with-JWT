package com.niit.movieservice.movieArtifact.controller;

import com.niit.movieservice.movieArtifact.exception.UserNotFoundException;
import com.niit.movieservice.movieArtifact.model.User;
import com.niit.movieservice.movieArtifact.service.SecurityTokenGenerator;
import com.niit.movieservice.movieArtifact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class UserController {

    private ResponseEntity responseEntity;
    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;


    @Autowired
    public UserController(UserService userService , SecurityTokenGenerator securityTokenGenerator)
    {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }


    //Should only give username and password
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) throws UserNotFoundException {


        Map<String, String> map = null;
        try {
            User userObj = userService.findByUsernameAndPassword(user.getUsername(), user.getPassword());
            if (userObj.getUsername().equals(user.getUsername())) {
                map = securityTokenGenerator.generateToken(user);
            }
            responseEntity = new ResponseEntity(map, HttpStatus.OK);
        }
        catch(UserNotFoundException e){
            throw new UserNotFoundException();
        }
        catch (Exception e){
            responseEntity = new ResponseEntity("Try after sometime!!!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    // first step - register the user
    @PostMapping("/register")
    public ResponseEntity saveUser(@RequestBody User user) {

        User createdUser = userService.saveUser(user);
        return responseEntity = new ResponseEntity("User Created" , HttpStatus.CREATED);
    }

}

