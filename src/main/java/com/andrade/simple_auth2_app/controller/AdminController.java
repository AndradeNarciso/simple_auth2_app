package com.andrade.simple_auth2_app.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrade.simple_auth2_app.domain.User;
import com.andrade.simple_auth2_app.service.AdminService;

import lombok.AllArgsConstructor;

@RequestMapping
@RestController("/Admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/get-all")
   @PreAuthorize("hasAuthority=SCOPE_ADMIN")
    public ResponseEntity<List<User>> getAllUser() {
        return ResponseEntity.status(HttpStatus.OK).body(adminService.getAllService());
    }
}
