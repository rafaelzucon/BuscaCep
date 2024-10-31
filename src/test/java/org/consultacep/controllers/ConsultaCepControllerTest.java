package org.consultacep.controllers;

import org.consultacep.models.ConsultaCepModel;
import org.consultacep.repositories.ConsultaCepRepository;
import org.consultacep.services.ConsultaCepService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.*;

public class ConsultaCepControllerTest {

    @InjectMocks
    ConsultaCepController consultaCepController;

    @Mock
    ConsultaCepService consultaCepService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    ConsultaCepRepository consultaCepRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        consultaCepService = new ConsultaCepService(consultaCepRepository);
    }

    @Test
    public void consultaCepSucesso() throws Exception {

        ResponseEntity<ConsultaCepModel> consultaCep = consultaCepController.consultaCep("03675000");
        assertEquals(consultaCep.getStatusCode(), HttpStatus.OK);

    }
}