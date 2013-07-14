package com.snommensen.user;

public interface UserService {

    User get(long id);

    User create(User user);
}
