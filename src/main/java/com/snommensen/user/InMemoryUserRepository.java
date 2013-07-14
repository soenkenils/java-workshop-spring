package com.snommensen.user;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

//@Repository
public class InMemoryUserRepository implements UserRepository {

    private static long ID_COUNTER = 0L;

    private Map<Long, User> users = new HashMap<>();

    @Override
    public User save(User user) {
        long id = ID_COUNTER++;
        user.setId(id);
        users.put(id, user);
        return user;
    }

    @Override
    public User findOne(Long id) {
        return users.get(id);
    }
}
