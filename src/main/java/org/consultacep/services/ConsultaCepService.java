package org.consultacep.services;

import org.consultacep.models.ConsultaCepModel;
import org.consultacep.repositories.ConsultaCepRepository;
import org.springframework.stereotype.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Service
public class ConsultaCepService {

    final ConsultaCepRepository consultaCepRepository;

    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private ObjectMapper objectMapper = new ObjectMapper();

    public ConsultaCepService(ConsultaCepRepository consultaCepRepository) {
        this.consultaCepRepository = consultaCepRepository;
    }

    public ConsultaCepModel findByCep(String cep) throws Exception {
        HttpGet request = new HttpGet("https://viacep.com.br/ws/" + cep + "/json");
        HttpResponse response = httpClient.execute(request);
        ConsultaCepModel consultaCepModel = new ConsultaCepModel();
        consultaCepModel = objectMapper.readValue(response.getEntity().getContent(), ConsultaCepModel.class);
        consultaCepModel.setDatahora(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")));
        return this.persisteLog(consultaCepModel);
    }

    @Transactional
    public ConsultaCepModel persisteLog(ConsultaCepModel consultaCepModel) throws Exception {
        return consultaCepRepository.save(consultaCepModel);
    }
}
