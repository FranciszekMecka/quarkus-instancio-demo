package com.example.fullstack.repository.user;

import com.example.fullstack.entity.user.User;
import com.example.fullstack.repository.UserRepository;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.instancio.Select.field;

@QuarkusTest
public class UserRepositoryUnitTest {

    @Inject
    UserRepository userRepository;

    @Test
    @TestTransaction
    void shouldPersistEntity_whenPersist_givenRandomEntity() {
        User user = Instancio.of(User.class)
            .ignore(field(User::getId))
            .create();

        userRepository.persist(user);

        assertThat(userRepository.findById(user.getId())).isNotNull();
    }

    @Test
    @TestTransaction
    void shouldPersistListOfEntities_whenPersist_givenRandomEntities() {
        List<User> users = Instancio.ofList(User.class)
            .size(1_000_000)
            .ignore(field(User::getId))
            .create();
    }
}
