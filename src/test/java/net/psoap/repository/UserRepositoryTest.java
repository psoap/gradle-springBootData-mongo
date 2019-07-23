package net.psoap.repository;

import lombok.extern.slf4j.Slf4j;
import net.psoap.Application;
import net.psoap.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Application.class})
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByLoginTest_shouldReturnsNotNullUser(){
        String login = "login";

        userRepository.insert(User.builder().login(login).password("pass").build());

        assertNotNull(userRepository.findByLogin(login));
    }

    @Test(expected = DuplicateKeyException.class)
    public void insertTwoEqualsUsersTest_shouldThrowsException(){
        String login = "login";

        userRepository.insert(User.builder().login(login).password("pass123").build());
        userRepository.insert(User.builder().login(login).password("pass456").build());
    }

}