package com.example.demo.restController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Role;
import com.example.demo.model.Track;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.restController.UserRestController;

public class UserRestControllerTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRestController userRestController;

    Set<Role> emptyRole;
    Set<Track> emptyTrack;

    // Adding Users
    User user1 = new User(1L, "Mithun", "mithun", "1313mithun@gmail.com",
            "$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW", emptyRole, emptyTrack);
    User user2 = new User(2L, "Krishnendhu", "krishnendhu", "krishnendhu123@gmail.com",
            "$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW", emptyRole, emptyTrack);
    User user3 = new User(3L, "Anudeep", "anudeep", "anudeep352@gmail.com",
            "$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW", emptyRole, emptyTrack);

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll_TestForEmpty() {
        List<User> mockResult = new ArrayList<>();

        when(userRepository.findAll()).thenReturn(mockResult);

        ResponseEntity<List<User>> currentResult = userRestController.findAll();

        assertEquals(currentResult, ResponseEntity.noContent().build());
    }

    @Test
    public void findAll_TestForNonEmpty() {
        List<User> mockResult = new ArrayList<>();
        mockResult.add(user1);
        mockResult.add(user2);
        mockResult.add(user3);

        when(userRepository.findAll()).thenReturn(mockResult);

        List<User> currentResult = userRestController.findAll().getBody();

        assertEquals(currentResult, mockResult);
    }

    @Test
    public void findByUsername_TestForEmpty() {
        Optional<User> mockResult = Optional.empty();

        when(userRepository.findByUsername(user1.getName())).thenReturn(mockResult);

        ResponseEntity<Optional<User>> currentResult = userRestController.findByUsername(user1.getName());

        assertEquals(currentResult, ResponseEntity.noContent().build());
    }

    @Test
    public void findByUsername_TestForNonEmpty() {
        Optional<User> mockResult = Optional.of(user1);

        when(userRepository.findByUsername(user1.getName())).thenReturn(mockResult);

        ResponseEntity<Optional<User>> currentResult = userRestController.findByUsername(user1.getName());

        assertEquals(currentResult.getBody(), mockResult);
    }

}
