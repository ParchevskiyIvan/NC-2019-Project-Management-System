package com.netcracker.edu.project.fapi.controller;

import com.netcracker.edu.project.fapi.model.AuthToken;
import com.netcracker.edu.project.fapi.model.AuthUser;
import com.netcracker.edu.project.fapi.model.UserModel;
import com.netcracker.edu.project.fapi.model.converter.ConvertUserTOAuthUser;
import com.netcracker.edu.project.fapi.security.TokenProvider;
import com.netcracker.edu.project.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    @RequestMapping(value = "/generate-token", method = RequestMethod.POST)
    public ResponseEntity generateToken(@RequestBody UserModel loginUser){
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getEmail(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping (value = "/sign-up", method = RequestMethod.POST)
    public ResponseEntity regNewUser(@RequestBody UserModel user){
        UserModel userAuth = copyUser(user);
        UserModel userResult = userService.saveUser(user);
        if(userResult == null) return ResponseEntity.badRequest().build();

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userAuth.getEmail(),
                        userAuth.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    private UserModel copyUser(UserModel user){
        UserModel copy = new UserModel();
        copy.setEmail(user.getEmail());
        copy.setPassword(user.getPassword());
        return copy;
    }

    @GetMapping("/user")
    public ResponseEntity<AuthUser> authUser(Principal user) {
        ConvertUserTOAuthUser convert = new ConvertUserTOAuthUser();
        UserModel userModel = userService.findByEmail(user.getName());
        if(userModel != null) {
            return ResponseEntity.ok(convert.convert(userModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}