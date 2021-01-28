package br.com.tgf.orcamento.orcamentoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tgf.orcamento.orcamentoapi.model.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
}
