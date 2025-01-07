package com.example.springboot.controller;

import com.example.springboot.dbo.req.UserReq;
import com.example.springboot.dbo.res.UserRes;
import com.example.springboot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/user")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<UserRes> getAllUser(){
        return userService.all();
    }
    @PostMapping
    public ResponseEntity<UserRes> createUser(@RequestBody UserReq user){
        return ResponseEntity.ok(userService.create(user));
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserRes> updateUser(@PathVariable Long id, @RequestBody UserReq userReq) {
        UserRes updatedUser = userService.update(id, userReq);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build(); // Trả về HTTP status 204 (No Content)
    }
    @GetMapping("/search")
    public ResponseEntity<List<UserRes>> searchUsersByName(@RequestParam String name) {
        return ResponseEntity.ok(userService.searchByName(name));
    }

}
