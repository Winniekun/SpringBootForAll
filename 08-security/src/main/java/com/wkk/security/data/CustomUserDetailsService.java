package com.wkk.security.data;

import com.wkk.security.domain.User;
import com.wkk.security.ext.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * TODO 类描述
 *
 * @author weikunkun
 * @since 2022/5/22
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () ->
                new UsernameNotFoundException("Username" + username + "iis invalid");

        User user = userRepository.findUserByUserName(username).orElseThrow(s);
        return new CustomUserDetails(user);
    }
}
