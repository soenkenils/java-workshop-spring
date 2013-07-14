package com.snommensen;

import com.snommensen.user.User;
import com.snommensen.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    final static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);

        User user = User.create("Peter", "Fox", "peter.fox@gmail.com");

        User createdUser = userService.create(user);

        LOG.info("Created user: " + createdUser);
    }
}
