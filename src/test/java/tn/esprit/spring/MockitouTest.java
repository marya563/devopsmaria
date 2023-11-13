package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Instructor;
import tn.esprit.spring.repositories.IInstructorRepository;
import tn.esprit.spring.services.InstructorServicesImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@Slf4j
@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MockitouTest {

    @Mock
    private IInstructorRepository instructorRepository;

    @InjectMocks
    private InstructorServicesImpl instructorServices;


    @Test
    @Order(0)
    public void testAddInstructor() {

        Instructor instructorToAdd = new Instructor(1L, "Test");
        when(instructorRepository.save(instructorToAdd)).thenReturn(instructorToAdd);

        Instructor result = instructorServices.addInstructor(instructorToAdd);

        // Assert
        assertEquals(instructorToAdd, result);
    }

    @Test
    @Order(1)
    public void testUpdateInstructor() {
        Instructor instructorToUpdate = new Instructor(1L, "Test");
        when(instructorRepository.save(instructorToUpdate)).thenReturn(instructorToUpdate);

        Instructor result = instructorServices.updateInstructor(instructorToUpdate);

        assertEquals(instructorToUpdate, result);
    }

    @Test
    @Order(2)
    public void testRetrieveAllInstructor() {

        List<Instructor> instructors = Arrays.asList(
                new Instructor(1L, "Test1"),
                new Instructor(2L, "Test2")
        );
        when(instructorRepository.findAll()).thenReturn(instructors);

        List<Instructor> result = instructorServices.retrieveAllInstructors();

        assertEquals(instructors, result);
    }


}

