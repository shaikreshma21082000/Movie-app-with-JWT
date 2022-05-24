package com.niit.movieservice.movieArtifact.service;


import com.niit.movieservice.movieArtifact.model.User;

import java.util.Map;

public interface SecurityTokenGenerator {

    Map<String,String> generateToken(User user);
}