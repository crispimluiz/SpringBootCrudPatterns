package com.finan.orcamento.repositories;

import com.finan.orcamento.model.OrcamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrcamentoModel, Long> {

}
