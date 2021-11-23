package com.nancy.backend.controllers;

import com.nancy.backend.documents.Roles;
import com.nancy.backend.documents.User;
import com.nancy.backend.services.UserService;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import static com.nancy.backend.JwtAuthorizationFilter.PREFIX;
import static com.nancy.backend.JwtAuthorizationFilter.KEY;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path = "/api/users")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class UserController {
    
    private final class UserAuthorization {
        private final User user;

        private UserAuthorization(User user) {
            this.user = user;
        }

        public User getUser() {
            return user;
        }

        public String getToken() {
            return generateToken(user.getId(), user.getRoles());
        }

        private String generateToken(Long id, Roles roles) {
            long currentTimeMillis = System.currentTimeMillis();
            List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                    .commaSeparatedStringToAuthorityList(roles.toString());
            return PREFIX + Jwts
                    .builder()
                    .setId(currentTimeMillis + ":" + id)
                    .setSubject(id.toString())
                    .claim("authorities", grantedAuthorities.stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date(currentTimeMillis))
                    .setExpiration(new Date(currentTimeMillis + 600000))
                    .signWith(SignatureAlgorithm.HS512,
                            KEY.getBytes()).compact();
        }
    
    }

    @Autowired
    private UserService userService;   
    
    @GetMapping
    public Iterable<User> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("login")
    public Object login(@RequestParam Long id, @RequestParam String password) {
        User user = userService.findByIdCard(id);
        return user == null ? null : new UserAuthorization(user);
    }
    
   
}
