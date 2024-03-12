package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Paper;
import com.example.demo.model.Track;
import com.example.demo.model.User;
import com.example.demo.repository.PaperRepository;
import com.example.demo.restController.PaperRestController;

@RunWith(MockitoJUnitRunner.class)
public class PaperRestControllerTest {
    
    @Mock
    private PaperRepository paperRepository;

    @InjectMocks
    private PaperRestController paperRestController;

    Set<Track> emptyTrack;
    User author=new User();

    Paper paper1=new Paper(1L,"Paper1","Paper1","UNASSIGNED",author,emptyTrack);
    Paper paper2=new Paper(2L,"Paper2","Paper2","UNDER_REVIEW",author,emptyTrack);
    Paper paper3=new Paper(3L,"Paper3","Paper3","COMPLETED_REVIEW",author,emptyTrack);

    @Before(value = " ")
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void findAll_Test(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper1);
        mockResult.add(paper2);
        mockResult.add(paper3);

        Mockito.when(paperRepository.findAll()).thenReturn(mockResult);

        List<Paper> currentResult=paperRestController.findAll();

        assertEquals(currentResult,mockResult);
    }

    @Test
    public void findById_Test(){
        Optional<Paper> mockResult=Optional.of(paper1);
        
        Mockito.when(paperRepository.findById(paper1.getPaperId())).thenReturn(mockResult);

        Optional<Paper> currentResult=paperRestController.findById(paper1.getPaperId());

        assertEquals(mockResult,currentResult);
    }

    @Test
    public void findByStatus_Test(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper2);

        Mockito.when(paperRepository.findByStatus(paper2.getStatus())).thenReturn(mockResult);

        List<Paper> currrentResult=paperRestController.findByStatus(paper2.getStatus());

        assertEquals(mockResult,currrentResult);
    }

    @Test
    public void findByAuthor_Test(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper1);
        mockResult.add(paper2);
        mockResult.add(paper3);

        Mockito.when(paperRepository.findByAuthor(paper1.getAuthor().getId())).thenReturn(mockResult);

        List<Paper> currentResult=paperRestController.findByAuthor(paper1.getAuthor().getId());

        assertEquals(mockResult,currentResult);
    }
}
