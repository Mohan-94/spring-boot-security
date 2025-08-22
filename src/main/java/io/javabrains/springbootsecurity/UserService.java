package io.javabrains.springbootsecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDetailsManager userDetailsManager;
    private final NotificationService notificationService;

    public UserService(UserDetailsManager userDetailsManager, NotificationService notificationService) {
        this.userDetailsManager = userDetailsManager;
        this.notificationService = notificationService;
    }

    public void registerUser(String username, String password) {
        UserDetails user = User.withUsername(username)
                .password(password)
                .roles("USER")
                .build();
        userDetailsManager.createUser(user);
        notificationService.notifyAdmin(username);
    }
}

