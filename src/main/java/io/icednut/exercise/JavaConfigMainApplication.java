package io.icednut.exercise;

import io.icednut.exercise.infra.entity.User;
import io.icednut.exercise.infra.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceTransactionManagerAutoConfiguration.class})
public class JavaConfigMainApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaConfigMainApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner(UserRepository userRepository) {
        return args -> {
            // INSERT DUMMY DATA
            List<User> users = new ArrayList<>();

            users.add(new User("Tom", 10));
            users.add(new User("Jerry", 12));
            users.add(new User("John", 20));
            users.add(new User("Terry", 24));
            users.add(new User("Jane", 31));
            userRepository.save(users);
        };
    }
}
