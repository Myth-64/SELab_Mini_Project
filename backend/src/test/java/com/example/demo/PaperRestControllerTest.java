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
import org.springframework.http.ResponseEntity;

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
    public void findAll_TestForEmpty(){
        List<Paper> mockResult=new ArrayList<>();

        Mockito.when(paperRepository.findAll()).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findAll();

        assertEquals(currentResult,ResponseEntity.noContent().build());
    }
    @Test
    public void findAll_TestForNonEmpty(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper1);
        mockResult.add(paper2);
        mockResult.add(paper3);

        Mockito.when(paperRepository.findAll()).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findAll();

        assertEquals(currentResult.getBody(),mockResult);
    }

    @Test
    public void findById_TestForEmpty(){
        Optional<Paper> mockResult=Optional.empty();
        
        Mockito.when(paperRepository.findById(paper1.getPaperId())).thenReturn(mockResult);

        ResponseEntity<Optional<Paper>> currentResult=paperRestController.findById(paper1.getPaperId());

        assertEquals(ResponseEntity.noContent().build(),currentResult);
    }
    @Test
    public void findById_TestForNonEmpty(){
        Optional<Paper> mockResult=Optional.of(paper1);
        
        Mockito.when(paperRepository.findById(paper1.getPaperId())).thenReturn(mockResult);

        ResponseEntity<Optional<Paper>> currentResult=paperRestController.findById(paper1.getPaperId());

        assertEquals(mockResult,currentResult.getBody());
    }

    @Test
    public void findByStatus_TestForEmpty(){
        List<Paper> mockResult=new ArrayList<>();

        Mockito.when(paperRepository.findByStatus(paper2.getStatus())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currrentResult=paperRestController.findByStatus(paper2.getStatus());

        assertEquals(ResponseEntity.noContent().build(),currrentResult);
    }
    @Test
    public void findByStatus_TestForNonEmpty(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper2);

        Mockito.when(paperRepository.findByStatus(paper2.getStatus())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currrentResult=paperRestController.findByStatus(paper2.getStatus());

        assertEquals(mockResult,currrentResult.getBody());
    }

    @Test
    public void findByAuthor_TestForEmpty(){
        List<Paper> mockResult=new ArrayList<>();

        Mockito.when(paperRepository.findByAuthor(paper1.getAuthor().getId())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findByAuthor(paper1.getAuthor().getId());

        assertEquals(ResponseEntity.noContent().build(),currentResult);
    }
    @Test
    public void findByAuthor_TestForNonEmpty(){
        List<Paper> mockResult=new ArrayList<>();
        mockResult.add(paper1);
        mockResult.add(paper2);
        mockResult.add(paper3);

        Mockito.when(paperRepository.findByAuthor(paper1.getAuthor().getId())).thenReturn(mockResult);

        ResponseEntity<List<Paper>> currentResult=paperRestController.findByAuthor(paper1.getAuthor().getId());

        assertEquals(mockResult,currentResult.getBody());
    }
}
