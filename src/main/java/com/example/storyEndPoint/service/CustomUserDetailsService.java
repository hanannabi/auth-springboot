package com.example.storyEndPoint.service;

import com.example.storyEndPoint.repository.UserManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserManagementRepository userManagementRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userManagementRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("Username Not Found"));
    }
}
