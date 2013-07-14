package com.snommensen.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.util.Assert.notNull;

//@Service
public class DefaultUserService implements UserService {

    final static Logger LOG = LoggerFactory.getLogger(DefaultUserService.class);

    private UserRepository userRepository;

    /**
     * Constructor based dependency injection.
     *
     * @param userRepository The user repository
     */
    public DefaultUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User get(long id) {
        LOG.info("get( id=" + id + " )");
        User user = userRepository.findOne(id);
        LOG.debug("found: " + user);
        return user;
    }

    @Override
    public User create(User user) {
        notNull(user, "Given user is null!");
        User savedUser = userRepository.save(user);
        LOG.debug("saved: " + savedUser);
        return savedUser;
    }
}
