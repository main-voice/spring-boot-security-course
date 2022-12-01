package com.example.demo.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.jwt
 * @author: peng peng
 * @date: 2022-12-01 18:23
 **/

// the job of this class is to validate credentials(username and password)
// spring security does it by default, but we can override it. so we need extend the class
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            // get user info
            UserInfoFromAuthRequest userInfoFromAuthRequest = new ObjectMapper().readValue(request.getInputStream(),
                    UserInfoFromAuthRequest.class);

            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    userInfoFromAuthRequest.getUsername(), // principal
                    userInfoFromAuthRequest.getPassword() // credential
            );
            // this manager will make sure that the username exists and if exists,
            // it will check whether the password is correct
            // if correct, the request will be authenticated
            Authentication authenticate = authenticationManager.authenticate(authentication);
            System.out.println("User has been Authenticated");
            return authenticate;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // this method will be invoked if the method attemptAuthentication return success
    // and its job is to create a token and return to client
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        String key = "securesecuresecuresecuresecuresecuresecuresecuresecure";

        String token = Jwts.builder()
                .setSubject(authResult.getName()) // ie.username
                .claim("authorities", authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusWeeks(2)))
                .signWith(Keys.hmacShaKeyFor(key.getBytes())) // the third part of token
                .compact();
        System.out.println("token has created! : ");
        // return token to client
        response.addHeader("Authorization", "Bearer" + token);
    }
}
