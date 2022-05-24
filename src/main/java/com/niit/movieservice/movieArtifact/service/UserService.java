package com.niit.movieservice.movieArtifact.service;


import com.niit.movieservice.movieArtifact.exception.UserNotFoundException;
import com.niit.movieservice.movieArtifact.model.User;

import java.util.List;


public interface UserService {
    public User saveUser(User user);
    public User findByUsernameAndPassword(String username , String password) throws UserNotFoundException;
}