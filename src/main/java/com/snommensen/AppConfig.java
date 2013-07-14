package com.snommensen;

import com.snommensen.user.InMemoryUserRepository;
import com.snommensen.user.UserRepository;
import com.snommensen.user.UserService;
import com.snommensen.user.DefaultUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class AppConfig {

    @Bean
    public UserService userService() {
        return new DefaultUserService(userRepository());
    }

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }
}