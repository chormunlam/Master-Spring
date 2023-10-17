package com.example.myspringwebapp.login;

public class AuthenticationService {
    public boolean authenticate(String username, String password){
        boolean isValidUserName=username.equalsIgnoreCase("cm");
        boolean isValidUserPassword=password.equalsIgnoreCase("ddd66");
        return isValidUserName && isValidUserPassword;
    }
}
