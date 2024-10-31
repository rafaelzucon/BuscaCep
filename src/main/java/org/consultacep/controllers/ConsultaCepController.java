package org.consultacep.controllers;

import org.consultacep.models.ConsultaCepModel;
import org.consultacep.services.ConsultaCepService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
public class ConsultaCepController {

    final ConsultaCepService consultaCepService;

    public ConsultaCepController(ConsultaCepService consultaCepService) {
        this.consultaCepService = consultaCepService;
    }

    @GetMapping("cep/{cep}")
    public ResponseEntity<ConsultaCepModel> consultaCep(@PathVariable String cep) throws Exception {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(consultaCepService.findByCep(cep));
        } catch (Exception e) {
            throw new RuntimeException("CEP inválido \n" + e.getMessage());
        }
    }
}
