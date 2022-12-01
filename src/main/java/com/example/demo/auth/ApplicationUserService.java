package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @program: spring-boot-security-course
 * @description:
 * @packagename: com.example.demo.auth
 * @author: peng peng
 * @date: 2022-12-01 15:58
 **/
@Service
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserDao applicationUserDao;

    // tell spring that you have one implementation
    // if you don't have the @Qualifier, it still works because we only have one implementation for now.
    @Autowired
    public ApplicationUserService(@Qualifier("fake") ApplicationUserDao applicationUserDao) {
        this.applicationUserDao = applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return applicationUserDao.selectAppUserByUsername(s)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("username %s not found", s)));
    }
}
