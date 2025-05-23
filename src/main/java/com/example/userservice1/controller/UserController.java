package com.example.userservice1.controller;

import com.example.userservice1.dtos.LoginRequestDto;
import com.example.userservice1.dtos.SignUpRequestDto;
import com.example.userservice1.dtos.UserResponseDto;
import com.example.userservice1.models.Token;
import com.example.userservice1.models.User;
import com.example.userservice1.services.ProductService;
import com.example.userservice1.services.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/users")


public class UserController {
    private UserService userService;
    private ProductService productService;

    UserController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/signup")
    public UserResponseDto signUp(@RequestBody SignUpRequestDto signUpRequestDto){
        User user = userService.signUp(signUpRequestDto.getName(),signUpRequestDto.getEmail(),signUpRequestDto.getPassword());
        return UserResponseDto.fromUser(user);
    }
    @PostMapping("/login")
    public Token login(@RequestBody LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto.getEmail(),loginRequestDto.getPassword());
    }

    @GetMapping("/validate/{token}")
    public UserResponseDto validateUser(@PathVariable String token){
        User user = userService.validateToken(token);
        if(user == null){
            return null;
        }
        return UserResponseDto.fromUser(user);
    }
    @GetMapping("path")
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    @GetMapping("/Product/{id}")
    public String getProductDetails(@PathVariable String id){
        return productService.getProductDetails(id);

    }
    

}
