package com.example.springjwt.service;


import com.example.springjwt.entitie.Role;
import com.example.springjwt.entitie.Users;
import com.example.springjwt.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;

    public CustomUserDetailsService(UsersRepository usersRepository, @Qualifier("myPassEncoder")PasswordEncoder encoder) {
        this.usersRepository = usersRepository;
        this.encoder = encoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = loadApplicationUserByUsername(username);

        String collect = user.getRoles().stream().map(Role::getName).map(role -> "ROLE_"+role).collect(Collectors.joining(","));
        List<GrantedAuthority> role_user = AuthorityUtils.commaSeparatedStringToAuthorityList(collect);

        return new User(user.getUsername(),user.getPassword() ,role_user );
    }

    private Users loadApplicationUserByUsername(String username) {
        Optional<Users> optionalUsers = usersRepository.findByUsername(username);

        return optionalUsers.map(users -> {
                    users.setPassword(encoder.encode(users.getPassword()));
                    return users;
                }).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

    }


}
