package com.kozelandrey.pricelist.services.authorization;

import com.kozelandrey.pricelist.dao.UserRepository;
import com.kozelandrey.pricelist.data.entity.User;
import com.kozelandrey.pricelist.exceptions.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) {
        User user = userRepository.findByLogin(login);

        if(user == null) {
            throw new AuthenticationException(String.format("The username %s doesn't exist", login));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();

        return new org.springframework.security.core.userdetails.
                User(user.getLogin(), user.getPassword(), authorities);
    }
}
