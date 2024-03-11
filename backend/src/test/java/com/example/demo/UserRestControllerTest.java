package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.model.Role;
import com.example.demo.model.Track;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.restController.UserRestController;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserRestController userRestController;

    Set<Role> emptyRole;
    Set<Track> emptyTrack;

    // Adding Users
    User user1=new User(1L,"Mithun","mithun","1313mithun@gmail.com","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW",emptyRole,emptyTrack);
    User user2=new User(2L,"Krishnendhu","krishnendhu","krishnendhu123@gmail.com","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW",emptyRole,emptyTrack);
    User user3=new User(3L,"Anudeep","anudeep","anudeep352@gmail.com","$2a$12$9VA5BOGoqgGhn/15NlP9Q.SZ.8Aj8j7PXEf7QoNa9tBLZ8fpImyhW",emptyRole,emptyTrack);

    @Before(value = "")
    public void setup(){
        MockitoAnnotations.openMocks(this);
        this.mockMvc=MockMvcBuilders.standaloneSetup(userRestController).build();
    }

    @Test
    public void findAll_Test(){
        List<User> mockResult=new ArrayList<>();
        mockResult.add(user1);
        mockResult.add(user2);
        mockResult.add(user3);

        
        Mockito.when(userRepository.findAll()).thenReturn(mockResult);
        
        List<User> currentResult=userRestController.findAll();

        assertEquals(currentResult.get(0).getName(),user1.getName());
        assertEquals(currentResult.get(1).getName(),user2.getName());
        assertEquals(currentResult.get(2).getName(),user3.getName());
    }

}
