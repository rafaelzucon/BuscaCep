package org.consultacep.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "TB_CONSULTA_CEP_LOG")
public class ConsultaCepModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column(nullable = true, length = 10)
    private String cep;
    @Column(nullable = true, length = 100)
    private String logradouro;
    @Column(nullable = true, length = 50)
    private String complemento;
    @Column(nullable = true, length = 30)
    private String unidade;
    @Column(nullable = true, length = 50)
    private String bairro;
    @Column(nullable = true, length = 50)
    private String localidade;
    @Column(nullable = true, length = 2)
    private String uf;
    @Column(nullable = true, length = 30)
    private String estado;
    @Column(nullable = true, length = 15)
    private String regiao;
    @Column(nullable = true, length = 10)
    private String ibge;
    @Column(nullable = true, length = 10)
    private String gia;
    @Column(nullable = true, length = 3)
    private String ddd;
    @Column(nullable = true, length = 10)
    private String siafi;
    @Column(nullable = true)
    private LocalDateTime datahora;

}
