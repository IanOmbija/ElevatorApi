package com.ezra.elevatorapi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.mock.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ezra.elevatorapi.controller.ElevatorController;
import com.ezra.elevatorapi.enums.Directions;
import com.ezra.elevatorapi.enums.Status;
import com.ezra.elevatorapi.model.Elevator;
import com.ezra.elevatorapi.service.ElevatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mock.*;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

//@ExtendWith(MockitoExtension.class)
//@DataJpaTest
@WebMvcTest(ElevatorController.class)
public class ElevatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ElevatorService elevatorService;
    private ElevatorController elevatorController;
    Elevator elevator;
    @Test
    public void testCallElevator() throws Exception {
        CallRequest request = new CallRequest();
        request.setFromFloor(1);
        request.setToFloor(5);
        Elevator elevator = new Elevator();
        elevator.setId(1L);
        elevator.setDirections(Directions.UP);
        elevator.setStatus(Status.PENDING);
       //given(elevatorController.callElevator(any())).willReturn(elevator);
    //    mockMvc.perform(post("/api/elevator/call")
    //    .contentType(MediaType.APPLICATION_JSON)
    //    .content(new ObjectMapper().writeValueAsString(request)))
    //    .andExpect(status().isOk())
    //    .andExpect(jsonPath("$.elevatorId", is(1)))
    //    .andExpect(jsonPath("$.fromFloor", is(1)))
    //    .andExpect(jsonPath("$.toFloor", is(5)))
    //    .andExpect(jsonPath("$.status", is("PENDING")));
        
        
    }
}
