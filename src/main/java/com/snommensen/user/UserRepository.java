package com.snommensen.user;

public interface UserRepository {

    User save(User user);

    User findOne(Long id);
}
