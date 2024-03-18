package com.example.demo.restController;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.TrackRepository;
import com.example.demo.repository.UserRepository;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/users")
public class UserRestController {
    
    @Autowired
    UserRepository userRepository;
    @Autowired
    TrackRepository trackRepository;

    @Operation(summary = "findAll", description="Return the list of all users")
    @GetMapping("")
    public ResponseEntity<List<User>> findAll(){
        List<User> userList=userRepository.findAll();
        if(userList.size()==0){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(userList);
        }
    }
}
