package org.consultacep.services;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.consultacep.models.ConsultaCepModel;
import org.consultacep.repositories.ConsultaCepRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ConsultaCepServiceTest {

    @InjectMocks
    ConsultaCepService consultaCepService;

    @Mock(answer = Answers.RETURNS_SMART_NULLS)
    ConsultaCepRepository consultaCepRepository;

    @Mock
    HttpClient httpClient;

    @Mock
    HttpGet httpGet;

    @Mock
    HttpResponse httpResponse;

    @Mock
    StatusLine statusLine;

    @Mock
    ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        consultaCepService = new ConsultaCepService(consultaCepRepository);
    }

    @Test
    public void findByCepSucesso() throws Exception {

        ConsultaCepModel consultaCepModel = new ConsultaCepModel();
        consultaCepModel.setCep("03675000");

        when(statusLine.getStatusCode()).thenReturn(200);
        when(httpResponse.getStatusLine()).thenReturn(statusLine);
        when(httpClient.execute(httpGet)).thenReturn(httpResponse);
        when(objectMapper.readValue((JsonParser) any(), (Class<Object>) any())).thenReturn(consultaCepModel);
        doReturn(consultaCepModel).when(consultaCepRepository).save(consultaCepModel);
        when(consultaCepService.persisteLog(any())).thenReturn(consultaCepModel);

        ConsultaCepModel consultaCep = consultaCepService.findByCep("03675000");
        assertEquals(consultaCepModel.getCep(), consultaCep.getCep());

    }

    @Test
    public void persisteLog() {
        ConsultaCepModel consultaCepModel = new ConsultaCepModel();
        consultaCepModel.setCep("03675000");
        doReturn(consultaCepModel).when(consultaCepRepository).save(consultaCepModel);
        ConsultaCepModel consultaCep = consultaCepRepository.save(consultaCepModel);
        assertEquals(consultaCepModel.getCep(), consultaCep.getCep());
    }
}