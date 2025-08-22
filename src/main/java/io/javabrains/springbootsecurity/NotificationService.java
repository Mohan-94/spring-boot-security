package io.javabrains.springbootsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    public void notifyAdmin(String username) {
        logger.info("Admin notified: new user '{}' requires authentication", username);
    }
}

