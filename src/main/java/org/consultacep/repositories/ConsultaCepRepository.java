package org.consultacep.repositories;

import org.consultacep.models.ConsultaCepModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ConsultaCepRepository extends JpaRepository<ConsultaCepModel, Long> {
}
