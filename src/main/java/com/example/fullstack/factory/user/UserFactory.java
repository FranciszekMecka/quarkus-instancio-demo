package com.example.fullstack.factory.user;

import com.example.fullstack.entity.user.User;
import com.example.fullstack.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.instancio.Instancio;

import java.util.List;

@ApplicationScoped
public class UserFactory {

    private final UserRepository userRepository;

    @Inject
    public UserFactory(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> createBatch(int amount) {
        return Instancio.ofList(User.class).size(amount).create();
    }

}
