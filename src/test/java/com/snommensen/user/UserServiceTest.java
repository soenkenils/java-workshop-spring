package com.snommensen.user;

import com.snommensen.AppConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class UserServiceTest {

    @Autowired
    UserService userService;
    User user;

    @Before
    public void setUp() {
        user = User.create("Peter", "Fox", "peter.fox@bla.com");
    }

    @Test
    public void create_userIsCreated() throws Exception {
        User createdUser = userService.create(user);

        User foundUser = userService.get(createdUser.getId());

        assertThat(foundUser.getId(), equalTo(user.getId()));

        assertThat(foundUser.getFirstName(), equalTo(user.getFirstName()));
        assertThat(foundUser.getLastName(), equalTo(user.getLastName()));
        assertThat(foundUser.getEmailAddress(), equalTo(user.getEmailAddress()));
    }

    @Test
    public void createTenUsers_tenUsersAreCreated() throws Exception {
        for (int i  = 0; i < 10; i++) {
            User createdUser = userService.create(user);

            User foundUser = userService.get(createdUser.getId());

            assertThat(foundUser.getId(), equalTo(user.getId()));
        }
    }

}
