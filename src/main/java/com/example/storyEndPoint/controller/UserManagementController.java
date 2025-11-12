package com.example.storyEndPoint.controller;

import com.example.storyEndPoint.dto.request.UserManagementRequest;
import com.example.storyEndPoint.dto.response.UserManagementResponse;
import com.example.storyEndPoint.enums.Role;
import com.example.storyEndPoint.service.UserManagementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserManagementController {

    private final UserManagementService userManagementService;

    public UserManagementController(UserManagementService userManagementService) {
        this.userManagementService = userManagementService;
    }

    @PostMapping("/register")
    public UserManagementResponse create(@RequestBody UserManagementRequest request) {
        request.setRole(Role.USER);
        return userManagementService.create(request);
    }

    @PostMapping("/admin/create")
    public UserManagementResponse registerByAdmin(@RequestBody UserManagementRequest request){
        return userManagementService.create(request);
    }


}
