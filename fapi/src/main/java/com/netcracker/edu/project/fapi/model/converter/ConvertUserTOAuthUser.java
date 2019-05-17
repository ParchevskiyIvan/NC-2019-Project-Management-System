package com.netcracker.edu.project.fapi.model.converter;

import com.netcracker.edu.project.fapi.model.AuthUser;
import com.netcracker.edu.project.fapi.model.UserModel;
import org.springframework.core.convert.converter.Converter;

public class ConvertUserTOAuthUser implements Converter<UserModel, AuthUser> {

    @Override
    public AuthUser convert(UserModel user) {
        AuthUser authUser = new AuthUser();
        authUser.setId(user.getId());
        authUser.setEmail(user.getEmail());
        authUser.setName(user.getName());
        authUser.setRole(user.getRole());
        return authUser;
    }
}
