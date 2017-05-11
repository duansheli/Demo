package com.example;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/user")
public class UserController {

  private final Map<String, List<String>> userDb = new HashMap<>();

  public UserController() {
    userDb.put("tom", Arrays.asList("user"));
    userDb.put("sally", Arrays.asList("user", "admin"));
  }

  @RequestMapping(value = "login", method = RequestMethod.POST)
  public LoginResponse login(@RequestBody final UserLogin login) throws ServletException {
    if (login.name == null || !userDb.containsKey(login.name)) {
      throw new ServletException("Invalid login");
    }
    List<String> userRoles = userDb.get(login.name);
    
    // 通过用户的信息生成jwt_token
    String jwt_token = Jwts.builder().setSubject(login.name).claim("roles", userRoles).setIssuedAt(new Date())
        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
    return new LoginResponse(jwt_token);
  }

  @SuppressWarnings("unused")
  private static class UserLogin {
    public String name;
    public String password;
  }

  @SuppressWarnings("unused")
  private static class LoginResponse {
    public String token;

    public LoginResponse(final String token) {
      this.token = token;
    }
  }
}
