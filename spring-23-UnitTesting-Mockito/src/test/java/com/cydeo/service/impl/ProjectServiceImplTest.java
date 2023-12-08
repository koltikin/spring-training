package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;
    @InjectMocks
    ProjectServiceImpl projectService;


    @Test
    void getByProjectCode_Test(){
        // Given part
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project());
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        // When part
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());

        // Then part
        InOrder inOrder = inOrder(projectRepository,projectMapper);

        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        assertNotNull(projectDTO);

    }

    @Test
    void getProjectCode_ExceptionTest(){
        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable = assertThrows(NoSuchElementException.class,()->projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");

        verify(projectMapper, never()).convertToDto(any(Project.class));

        assertEquals("Project Not Found", throwable.getMessage());
    }

}